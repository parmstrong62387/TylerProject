package com.swx.core.http;

import com.swx.core.io.StringPrintWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 *
 * @author Patrick Armstrong
 * An extension of HttpServletResponseWrapper which makes use of a StringPrintWriter.
 */
public class CustomHttpServletResponse extends HttpServletResponseWrapper {
    
    private StringPrintWriter writer;
    
    public CustomHttpServletResponse(HttpServletResponse response) {
        super(response);
    }
    
    /**
     * Keep track of the wrapper StringPrintWriter object.
     * @throws IOException 
     */
    private void initWriter() throws IOException {
        if (writer == null) {
            writer = new StringPrintWriter(getResponse().getWriter());
        }
    }
    
    /**
     * Returns the StringPrintWriter object as a PrintWriter.
     * @return A PrintWriter
     * @throws IOException 
     */
    @Override
    public PrintWriter getWriter() throws IOException {
        initWriter();
        return writer;
    }
    
    /**
     * Returns the StringPrintWRiter object.
     * @return A StringPrintWriter
     * @throws IOException 
     */
    public StringPrintWriter getStringPrintWriter() throws IOException {
        initWriter();
        return writer;
    }
    
}
