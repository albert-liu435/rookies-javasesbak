package ex03.pyrmont.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname RequestUtil
 * @Description TODO
 * @Author rookie
 * @Date 2021/12/17 16:44
 * @Version 1.0
 */
public final class RequestUtil {

    /**
     * Build an appropriate return value for
     * {@link HttpServletRequest#getRequestURL()} based on the provided
     * request object. Note that this will also work for instances of
     * {@link javax.servlet.http.HttpServletRequestWrapper}.
     *
     * @param request The request object for which the URL should be built
     *
     * @return The request URL for the given request object
     */
    public static StringBuffer getRequestURL(HttpServletRequest request) {
        StringBuffer url = new StringBuffer();
        String scheme = request.getScheme();
        int port = request.getServerPort();
        if (port < 0) {
            // Work around java.net.URL bug
            port = 80;
        }

        url.append(scheme);
        url.append("://");
        url.append(request.getServerName());
        if ((scheme.equals("http") && (port != 80))
                || (scheme.equals("https") && (port != 443))) {
            url.append(':');
            url.append(port);
        }
        url.append(request.getRequestURI());

        return url;
    }
}