package com.netty.guide.chapter12.struct;

/**
 * @Classname NettyMessage
 * @Description TODO
 * @Author rookie
 * @Date 2022/3/7 15:45
 * @Version 1.0
 */
public final class NettyMessage {
    //消息头
    private Header header;
    //消息体
    private Object body;

    /**
     * @return the header
     */
    public final Header getHeader() {
        return header;
    }

    /**
     * @param header the header to set
     */
    public final void setHeader(Header header) {
        this.header = header;
    }

    /**
     * @return the body
     */
    public final Object getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public final void setBody(Object body) {
        this.body = body;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "NettyMessage [header=" + header + "]";
    }
}

