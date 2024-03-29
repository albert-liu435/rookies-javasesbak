/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.org.apache.juli.logging;

import aQute.bnd.annotation.spi.ServiceConsumer;

import java.lang.reflect.Constructor;
import java.nio.file.FileSystems;
import java.util.ServiceLoader;
import java.util.logging.LogManager;

/**
 * Juli日志工厂
 * This is a modified LogFactory that uses a simple {@link ServiceLoader} based
 * discovery mechanism with a default of using JDK based logging. An
 * implementation that uses the full Commons Logging discovery mechanism is
 * available as part of the Tomcat extras download.
 * <p>
 * Why? It is an attempt to strike a balance between simpler code (no discovery)
 * and providing flexibility - particularly for those projects that embed Tomcat
 * or some of Tomcat's components - is an alternative logging
 * implementation is desired.
 * <p>
 * Note that this implementation is not just a wrapper around JDK logging (like
 * the original commons-logging impl). It adds 2 features - a simpler
 * configuration  (which is in fact a subset of log4j.properties) and a
 * formatter that is less ugly.
 * <p>
 * The removal of 'abstract' preserves binary backward compatibility. It is
 * possible to preserve the abstract - and introduce another (hardcoded) factory
 * - but I see no benefit.
 * <p>
 * Since this class is not intended to be extended - all protected methods are
 * removed. This can be changed - but again, there is little value in keeping
 * dead code. Just take a quick look at the removed code ( and it's complexity).
 * <p>
 * --------------
 * <p>
 * Original comment:
 * <p>Factory for creating {@link com.org.apache.juli.logging.Log} instances, with discovery and
 * configuration features similar to that employed by standard Java APIs
 * such as JAXP.</p>
 *
 * <p><strong>IMPLEMENTATION NOTE</strong> - This implementation is heavily
 * based on the SAXParserFactory and DocumentBuilderFactory implementations
 * (corresponding to the JAXP pluggability APIs) found in Apache Xerces.</p>
 *
 * @author Craig R. McClanahan
 * @author Costin Manolache
 * @author Richard A. Sitze
 */
@ServiceConsumer(value = com.org.apache.juli.logging.Log.class)
public class LogFactory {
    //单例工厂实例
    private static final LogFactory singleton = new LogFactory();
    //用于存储Log的构造方法
    private final Constructor<? extends com.org.apache.juli.logging.Log> discoveredLogConstructor;

    /**
     * Private constructor that is not available for public use.
     */
    private LogFactory() {
        /*
         * Work-around known a JRE bug.
         * https://bugs.openjdk.java.net/browse/JDK-8194653
         *
         * Pre-load the default file system. No performance impact as we need to
         * load the default file system anyway. Just do it earlier to avoid the
         * potential deadlock.
         *
         * This can be removed once the oldest JRE supported by Tomcat includes
         * a fix.
         */
        FileSystems.getDefault();

        // Look via a ServiceLoader for a Log implementation that has a
        // constructor taking the String name.
        ServiceLoader<com.org.apache.juli.logging.Log> logLoader = ServiceLoader.load(com.org.apache.juli.logging.Log.class);
        Constructor<? extends com.org.apache.juli.logging.Log> m = null;
        for (com.org.apache.juli.logging.Log log : logLoader) {
            Class<? extends com.org.apache.juli.logging.Log> c = log.getClass();
            try {
                m = c.getConstructor(String.class);
                break;
            } catch (NoSuchMethodException | SecurityException e) {
                throw new Error(e);
            }
        }
        discoveredLogConstructor = m;
    }


    // --------------------------------------------------------- Public Methods

    // only those 2 methods need to change to use a different direct logger.

    /**
     * <p>Construct (if necessary) and return a <code>Log</code> instance,
     * using the factory's current set of configuration attributes.</p>
     *
     * <p><strong>NOTE</strong> - Depending upon the implementation of
     * the <code>LogFactory</code> you are using, the <code>Log</code>
     * instance you are returned may or may not be local to the current
     * application, and may or may not be returned again on a subsequent
     * call with the same name argument.</p>
     *
     * @param name Logical name of the <code>Log</code> instance to be
     *             returned (the meaning of this name is only known to the underlying
     *             logging implementation that is being wrapped)
     * @return A log instance with the requested name
     * @throws com.org.apache.juli.logging.LogConfigurationException if a suitable <code>Log</code>
     *                                   instance cannot be returned
     */
    public com.org.apache.juli.logging.Log getInstance(String name) throws com.org.apache.juli.logging.LogConfigurationException {
        if (discoveredLogConstructor == null) {
            return com.org.apache.juli.logging.DirectJDKLog.getInstance(name);
        }

        try {
            return discoveredLogConstructor.newInstance(name);
        } catch (ReflectiveOperationException | IllegalArgumentException e) {
            throw new com.org.apache.juli.logging.LogConfigurationException(e);
        }
    }


    /**
     * Convenience method to derive a name from the specified class and
     * call <code>getInstance(String)</code> with it.
     *
     * @param clazz Class for which a suitable Log name will be derived
     * @return A log instance with a name of clazz.getName()
     * @throws com.org.apache.juli.logging.LogConfigurationException if a suitable <code>Log</code>
     *                                   instance cannot be returned
     */
    public com.org.apache.juli.logging.Log getInstance(Class<?> clazz) throws com.org.apache.juli.logging.LogConfigurationException {
        return getInstance(clazz.getName());
    }


    // ------------------------------------------------------- Static Variables


    // --------------------------------------------------------- Static Methods


    /**
     * <p>Construct (if necessary) and return a <code>LogFactory</code>
     * instance, using the following ordered lookup procedure to determine
     * the name of the implementation class to be loaded.</p>
     * <ul>
     * <li>The <code>org.apache.commons.logging.LogFactory</code> system
     *     property.</li>
     * <li>The JDK 1.3 Service Discovery mechanism</li>
     * <li>Use the properties file <code>commons-logging.properties</code>
     *     file, if found in the class path of this class.  The configuration
     *     file is in standard <code>java.util.Properties</code> format and
     *     contains the fully qualified name of the implementation class
     *     with the key being the system property defined above.</li>
     * <li>Fall back to a default implementation class
     *     (<code>org.apache.commons.logging.impl.LogFactoryImpl</code>).</li>
     * </ul>
     *
     * <p><em>NOTE</em> - If the properties file method of identifying the
     * <code>LogFactory</code> implementation class is utilized, all of the
     * properties defined in this file will be set as configuration attributes
     * on the corresponding <code>LogFactory</code> instance.</p>
     *
     * @return The singleton LogFactory instance
     * @throws com.org.apache.juli.logging.LogConfigurationException if the implementation class is not
     *                                   available or cannot be instantiated.
     */
    public static LogFactory getFactory() throws com.org.apache.juli.logging.LogConfigurationException {
        return singleton;
    }


    /**返回命名记录器的便捷方法，应用程序无需关心工厂。
     * Convenience method to return a named logger, without the application
     * having to care about factories.
     *
     * @param clazz Class from which a log name will be derived
     * @return A log instance with a name of clazz.getName()
     * @throws com.org.apache.juli.logging.LogConfigurationException if a suitable <code>Log</code>
     *                                   instance cannot be returned
     */
    public static com.org.apache.juli.logging.Log getLog(Class<?> clazz)
        throws com.org.apache.juli.logging.LogConfigurationException {
        return getFactory().getInstance(clazz);
    }


    /**
     * Convenience method to return a named logger, without the application
     * having to care about factories.
     *
     * @param name Logical name of the <code>Log</code> instance to be
     *             returned (the meaning of this name is only known to the underlying
     *             logging implementation that is being wrapped)
     * @return A log instance with the requested name
     * @throws com.org.apache.juli.logging.LogConfigurationException if a suitable <code>Log</code>
     *                                   instance cannot be returned
     */
    public static com.org.apache.juli.logging.Log getLog(String name)
        throws com.org.apache.juli.logging.LogConfigurationException {
        return getFactory().getInstance(name);
    }


    /**
     * Release any internal references to previously created {@link LogFactory}
     * instances that have been associated with the specified class loader
     * (if any), after calling the instance method <code>release()</code> on
     * each of them.
     *
     * @param classLoader ClassLoader for which to release the LogFactory
     */
    public static void release(ClassLoader classLoader) {
        // JULI's log manager looks at the current classLoader so there is no
        // need to use the passed in classLoader, the default implementation
        // does not so calling reset in that case will break things
        if (!LogManager.getLogManager().getClass().getName().equals(
            "java.util.logging.LogManager")) {
            LogManager.getLogManager().reset();
        }
    }
}
