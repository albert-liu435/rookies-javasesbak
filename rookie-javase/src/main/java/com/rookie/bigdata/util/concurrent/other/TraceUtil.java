package com.rookie.bigdata.util.concurrent.other;

/**
 * @Classname TraceUtil
 * @Description TODO
 * @Author rookie
 * @Date 2021/11/18 16:42
 * @Version 1.0
 */
public class TraceUtil {
    public static final String REQUEST_HEADER_TRACE_ID = "com.ms.header.trace.id";
    public static final String MDC_TRACE_ID = "trace_id";
    private static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
    /**
     * 获取traceid
     *
     * @return
     */
    public static String get() {
        String traceId = inheritableThreadLocal.get();
        if (traceId == null) {
           // traceId = IDUtil.getId();
            inheritableThreadLocal.set(traceId);
        }
        return traceId;
    }
    public static void set(String trace_id) {
        inheritableThreadLocal.set(trace_id);
    }
    public static void remove() {
        inheritableThreadLocal.remove();
    }
}
