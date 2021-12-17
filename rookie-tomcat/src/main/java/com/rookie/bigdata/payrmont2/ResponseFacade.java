package com.rookie.bigdata.payrmont2;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

/**
 * @Classname ResponseFacade
 * @Description TODO
 * @Author rookie
 * @Date 2021/12/17 15:10
 * @Version 1.0
 */
public class ResponseFacade implements ServletResponse {


    private ServletResponse servletResponse;

    public ResponseFacade(ServletResponse servletResponse) {
        this.servletResponse = servletResponse;
    }

    @Override
    public String getCharacterEncoding() {
        return this.servletResponse.getCharacterEncoding();
    }

    @Override
    public String getContentType() {
        return this.servletResponse.getContentType();
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return this.servletResponse.getOutputStream();
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return this.servletResponse.getWriter();
    }

    @Override
    public void setCharacterEncoding(String charset) {
        this.servletResponse.setCharacterEncoding(charset);
    }

    @Override
    public void setContentLength(int len) {
        this.servletResponse.setContentLength(len);
    }

    @Override
    public void setContentLengthLong(long len) {
        this.servletResponse.setContentLengthLong(len);
    }

    @Override
    public void setContentType(String type) {
        this.servletResponse.setContentType(type);
    }

    @Override
    public void setBufferSize(int size) {
        this.servletResponse.setBufferSize(size);
    }

    @Override
    public int getBufferSize() {
        return this.servletResponse.getBufferSize();
    }

    @Override
    public void flushBuffer() throws IOException {
        this.servletResponse.flushBuffer();
    }

    @Override
    public void resetBuffer() {
        this.servletResponse.resetBuffer();
    }

    @Override
    public boolean isCommitted() {
        return this.servletResponse.isCommitted();
    }

    @Override
    public void reset() {
        this.servletResponse.reset();
    }

    @Override
    public void setLocale(Locale loc) {
        this.servletResponse.setLocale(loc);
    }

    @Override
    public Locale getLocale() {
        return this.servletResponse.getLocale();
    }
}
