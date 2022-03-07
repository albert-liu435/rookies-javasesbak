package com.netty.guide.chapter12.struct;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Header
 * @Description TODO
 * @Author rookie
 * @Date 2022/3/7 15:34
 * @Version 1.0
 */
public class Header {
    //0xabef表示该消息是Netty协议
    //crcCode=0xabef+主版本号+次版本号
    private int crcCode = 0xabef0101;

    private int length;// 消息长度。包括消息头和消息体

    private long sessionID;// 会话ID，集群内节点唯一

    //0:业务请求消息
    //1：业务响应消息
    //2：业务One WAY消息(既是请求又是响应消息)
    //3：握手请求消息
    //4：握手应答消息
    //5：心跳消息
    //6:心跳应答消息

    private byte type;// 消息类型
    //消息优先级：0-255
    private byte priority;// 消息优先级
    //可选字段，用于扩展消息头
    private Map<String, Object> attachment = new HashMap<String, Object>(); // 附件

    /**
     * @return the crcCode
     */
    public final int getCrcCode() {
        return crcCode;
    }

    /**
     * @param crcCode
     *            the crcCode to set
     */
    public final void setCrcCode(int crcCode) {
        this.crcCode = crcCode;
    }

    /**
     * @return the length
     */
    public final int getLength() {
        return length;
    }

    /**
     * @param length
     *            the length to set
     */
    public final void setLength(int length) {
        this.length = length;
    }

    /**
     * @return the sessionID
     */
    public final long getSessionID() {
        return sessionID;
    }

    /**
     * @param sessionID
     *            the sessionID to set
     */
    public final void setSessionID(long sessionID) {
        this.sessionID = sessionID;
    }

    /**
     * @return the type
     */
    public final byte getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public final void setType(byte type) {
        this.type = type;
    }

    /**
     * @return the priority
     */
    public final byte getPriority() {
        return priority;
    }

    /**
     * @param priority
     *            the priority to set
     */
    public final void setPriority(byte priority) {
        this.priority = priority;
    }

    /**
     * @return the attachment
     */
    public final Map<String, Object> getAttachment() {
        return attachment;
    }

    /**
     * @param attachment
     *            the attachment to set
     */
    public final void setAttachment(Map<String, Object> attachment) {
        this.attachment = attachment;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Header [crcCode=" + crcCode + ", length=" + length
                + ", sessionID=" + sessionID + ", type=" + type + ", priority="
                + priority + ", attachment=" + attachment + "]";
    }
}
