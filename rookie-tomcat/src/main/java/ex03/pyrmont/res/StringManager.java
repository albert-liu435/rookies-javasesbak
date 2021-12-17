package ex03.pyrmont.res;


import java.text.MessageFormat;
import java.util.*;

/**
 * 每一个包中都有一组properties
 * 文件StringManager为每个package创建一个对象，并通过内部的HashTable类型的私有变量managers来管理，
 * 显然，这采用了对象的<b>多例模式</b>。
 * 每个包中都有一个LocalStrings.properties的配置文件，定义公用提示信息
 * <p>
 * 每个使用的类中都添加StringManager对象
 * An internationalization / localization helper class which reduces
 * the bother of handling ResourceBundles and takes care of the
 * common cases of message formatting which otherwise require the
 * creation of Object arrays and such.
 *
 * <p>The StringManager operates on a package basis. One StringManager
 * per package can be created and accessed via the getManager method
 * call.
 *
 * <p>The StringManager will look for a ResourceBundle named by
 * the package name given plus the suffix of "LocalStrings". In
 * practice, this means that the localized information will be contained
 * in a LocalStrings.properties file located in the package
 * directory of the class path.
 *
 * <p>Please see the documentation for java.util.ResourceBundle for
 * more information.
 *
 * @author James Duncan Davidson [duncan@eng.sun.com]
 * @author James Todd [gonzo@eng.sun.com]
 * @author Mel Martinez [mmartinez@g1440.com]
 * @see java.util.ResourceBundle
 */
public class StringManager {

    private static int LOCALE_CACHE_SIZE = 10;

    /**
     * 用于读取相应包下的配置文件
     * The ResourceBundle for this StringManager.
     */
    private final ResourceBundle bundle;
    private final Locale locale;


    /**
     * 私有的构造方法能够保证外界无法实例化自己，这也是单例实现的关键步骤
     * Creates a new StringManager for a given package. This is a
     * private method and all access to it is arbitrated by the
     * static getManager method call so that only one StringManager
     * per package will be created.
     *
     * @param packageName Name of package to create StringManager for.
     */
    private StringManager(String packageName, Locale locale) {
        //获取各包下配置文件的路径
        // properties文件所在的package+“.LocalStrings”
        // 所有tomcat的日志使用的properties文件都依照这个形式来命名的
        String bundleName = packageName + ".LocalStrings";
        ResourceBundle bnd = null;
        try {
            // The ROOT Locale uses English. If English is requested, force the
            // use of the ROOT Locale else incorrect results may be obtained if
            // the system default locale is not English and translations are
            // available for the system default locale.
            if (locale.getLanguage().equals(Locale.ENGLISH.getLanguage())) {
                locale = Locale.ROOT;
            }
            // 根据bundleName取得解析资源文件的实例
            bnd = ResourceBundle.getBundle(bundleName, locale);
        } catch (MissingResourceException ex) {
            // Try from the current loader (that's the case for trusted apps)
            // Should only be required if using a TC5 style classloader structure
            // where common != shared != server
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            if (cl != null) {
                try {
                    bnd = ResourceBundle.getBundle(bundleName, locale, cl);
                } catch (MissingResourceException ex2) {
                    // Ignore
                }
            }
        }
        bundle = bnd;
        // Get the actual locale, which may be different from the requested one
        if (bundle != null) {
            Locale bundleLocale = bundle.getLocale();
            if (bundleLocale.equals(Locale.ROOT)) {
                this.locale = Locale.ENGLISH;
            } else {
                this.locale = bundleLocale;
            }
        } else {
            this.locale = null;
        }
    }


    /**
     * get时，通过内部对象bundle读取properties文件内容
     * Get a string from the underlying resource bundle or return null if the
     * String is not found.
     *
     * @param key to desired resource String
     * @return resource String matching <i>key</i> from underlying bundle or
     * null if not found.
     * @throws IllegalArgumentException if <i>key</i> is null
     */
    public String getString(String key) {
        if (key == null) {
            String msg = "key may not have a null value";
            throw new IllegalArgumentException(msg);
        }

        String str = null;

        try {
            // Avoid NPE if bundle is null and treat it like an MRE
            if (bundle != null) {
                str = bundle.getString(key);
            }
        } catch (MissingResourceException mre) {
            //bad: shouldn't mask an exception the following way:
            //   str = "[cannot find message associated with key '" + key +
            //         "' due to " + mre + "]";
            //     because it hides the fact that the String was missing
            //     from the calling code.
            //good: could just throw the exception (or wrap it in another)
            //      but that would probably cause much havoc on existing
            //      code.
            //better: consistent with container pattern to
            //      simply return null.  Calling code can then do
            //      a null check.
            str = null;
        }

        return str;
    }


    /**
     * Get a string from the underlying resource bundle and format
     * it with the given set of arguments.
     *
     * @param key  The key for the required message
     * @param args The values to insert into the message
     * @return The request string formatted with the provided arguments or the
     * key if the key was not found.
     */
    public String getString(final String key, final Object... args) {
        String value = getString(key);
        if (value == null) {
            value = key;
        }

        try {
            value = new String(value.getBytes("ISO-8859-1"), "UTF-8");

        } catch (Exception e) {
            e.printStackTrace();

        }


        MessageFormat mf = new MessageFormat(value);
        mf.setLocale(locale);
        return mf.format(args, new StringBuffer(), null).toString();
    }


    /**
     * Identify the Locale this StringManager is associated with.
     *
     * @return The Locale associated with the StringManager
     */
    public Locale getLocale() {
        return locale;
    }


    // --------------------------------------------------------------
    // STATIC SUPPORT METHODS
    // --------------------------------------------------------------
//使用Hashtable存放各包对应的StringManager对象，以便使用时直接通过get(packageName) 调用
    private static final Map<String, Map<Locale, StringManager>> managers =
            new Hashtable<>();


    /**
     * Get the StringManager for a given class. The StringManager will be
     * returned for the package in which the class is located. If a manager for
     * that package already exists, it will be reused, else a new
     * StringManager will be created and returned.
     *
     * @param clazz The class for which to retrieve the StringManager
     * @return The instance associated with the package of the provide class
     */
    public static final StringManager getManager(Class<?> clazz) {
        return getManager(clazz.getPackage().getName());
    }


    /**
     * Get the StringManager for a particular package. If a manager for
     * a package already exists, it will be reused, else a new
     * StringManager will be created and returned.
     *
     * @param packageName The package name
     * @return The instance associated with the given package and the default
     * Locale
     */
    public static final StringManager getManager(String packageName) {
        return getManager(packageName, Locale.getDefault());
    }


    /**
     * Get the StringManager for a particular package and Locale. If a manager
     * for a package/Locale combination already exists, it will be reused, else
     * a new StringManager will be created and returned.
     *
     * @param packageName The package name
     * @param locale      The Locale
     * @return The instance associated with the given package and Locale
     */
    public static final synchronized StringManager getManager(
            String packageName, Locale locale) {

        Map<Locale, StringManager> map = managers.get(packageName);
        if (map == null) {
            /*
             * Don't want the HashMap to be expanded beyond LOCALE_CACHE_SIZE.
             * Expansion occurs when size() exceeds capacity. Therefore keep
             * size at or below capacity.
             * removeEldestEntry() executes after insertion therefore the test
             * for removal needs to use one less than the maximum desired size
             *
             */
            map = new LinkedHashMap<Locale, StringManager>(LOCALE_CACHE_SIZE, 1, true) {
                private static final long serialVersionUID = 1L;

                @Override
                protected boolean removeEldestEntry(
                        Map.Entry<Locale, StringManager> eldest) {
                    if (size() > (LOCALE_CACHE_SIZE - 1)) {
                        return true;
                    }
                    return false;
                }
            };
            managers.put(packageName, map);
        }

        StringManager mgr = map.get(locale);
        if (mgr == null) {
            mgr = new StringManager(packageName, locale);
            map.put(locale, mgr);
        }
        return mgr;
    }


    /**
     * Retrieve the StringManager for a list of Locales. The first StringManager
     * found will be returned.
     *
     * @param packageName      The package for which the StringManager was
     *                         requested
     * @param requestedLocales The list of Locales
     * @return the found StringManager or the default StringManager
     */
    public static StringManager getManager(String packageName,
                                           Enumeration<Locale> requestedLocales) {
        while (requestedLocales.hasMoreElements()) {
            Locale locale = requestedLocales.nextElement();
            StringManager result = getManager(packageName, locale);
            if (result.getLocale().equals(locale)) {
                return result;
            }
        }
        // Return the default
        return getManager(packageName);
    }
}