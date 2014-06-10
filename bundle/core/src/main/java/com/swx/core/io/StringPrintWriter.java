package com.swx.core.io;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Locale;

/**
 *
 * @author Patrick Armstrong
 * Extends <code>PrintWriter</code>, but redirects all write commands into a <code>StringBuilder</code> rather than an <code>OutputStream</code>.<br/>
 * The StringBuilder contents can be accessed via <code>getWrittenContents</code> and cleared via <code>clear</code>.
 */
public class StringPrintWriter extends PrintWriter {
    
    /**
     * The variable used to track output.
     */
    private StringBuilder sb;
    
    /**
     * Use the same new line as the original PrintWriter.
     */
    private static final String NEW_LINE = System.getProperty("line.separator");
    
    public StringPrintWriter(File file) throws IOException {
        super(file);
        init();
    }
    
    public StringPrintWriter(File file, String csn) throws IOException {
        super(file, csn);
        init();
    }
    
    public StringPrintWriter(OutputStream out) throws IOException {
        super(out);
        init();
    }
    
    public StringPrintWriter(OutputStream out, boolean autoFlush) throws IOException {
        super(out, autoFlush);
        init();
    }
    
    public StringPrintWriter(String fileName) throws IOException {
        super(fileName);
        init();
    }
    
    public StringPrintWriter(String fileName, String csn) throws IOException {
        super(fileName, csn);
        init();
    }
    
    public StringPrintWriter(Writer out) throws IOException {
        super(out);
        init();
    }
    
    public StringPrintWriter(Writer out, boolean autoFlush) throws IOException {
        super(out, autoFlush);
        init();
    }
    
    private void init() {
        sb = new StringBuilder();
    }
    
    /**
     * Return the contents which have been written to the Writer.
     * @return The written data.
     */
    public String getWrittenContents() {
        return sb.toString();
    }
    
    /**
     * Clear the contents of the writer.
     */
    public void clear() {
        sb = new StringBuilder();
    }
    
    /***************************************************************
     * 
     * OVERRIDES TO WRITE METHODS
     * 
     * These methods simply append to a string builder instead of writing to a stream.
     * 
     ****************************************************************/
    
    /* (non-Javadoc)
     * @see java.io.PrintWriter#append(char)
     */
    @Override
    public PrintWriter append(char c)
    {
        write(c);
        return this;
    }
    
    /* (non-Javadoc)
     * @see java.io.PrintWriter#append(CharSequence, int, int)
     */
    @Override
    public PrintWriter append(CharSequence csq, int start, int end)
    {
        write(csq.subSequence(start, end).toString());
        return this;
    }
    
    /* (non-Javadoc)
     * @see java.io.PrintWriter#append(CharSequence)
     */
    @Override
    public PrintWriter append(CharSequence csq)
    {
        write(csq.toString());
        return this;
    }
    
    /* (non-Javadoc)
     * @see java.io.PrintWriter#format(String, Object...)
     */
    @Override
    public PrintWriter format(String format, Object... args)
    {
        write(String.format(format, args));
        return this;
    }
    
    /* (non-Javadoc)
     * @see java.io.PrintWriter#printf(String, Object...)
     */
    @Override
    public PrintWriter printf(String format, Object... args)
    {
        return format(format, args);
    }
    
    /* (non-Javadoc)
     * @see java.io.PrintWriter#format(Locale, String, Object...)
     */
    @Override
    public PrintWriter format(Locale l, String format, Object... args)
    {
        write(String.format(l, format, args));
        return this;
    }
    
    /* (non-Javadoc)
     * @see java.io.PrintWriter#printf(Locale, String, Object...)
     */
    @Override
    public PrintWriter printf(Locale l, String format, Object... args)
    {
        return format(l, format, args);
    }
    
     /* (non-Javadoc)
     * @see java.io.PrintWriter#print(boolean)
     */
    @Override
    public void print(boolean x)
    {
        sb.append(x);
    }

    /* (non-Javadoc)
     * @see java.io.PrintWriter#print(char)
     */
    @Override
    public void print(char x)
    {
        sb.append(x);
    }

    /* (non-Javadoc)
     * @see java.io.PrintWriter#print(int)
     */
    @Override
    public void print(int x)
    {
        sb.append(x);
    }

    /* (non-Javadoc)
     * @see java.io.PrintWriter#print(long)
     */
    @Override
    public void print(long x)
    {
        sb.append(x);
    }

    /* (non-Javadoc)
     * @see java.io.PrintWriter#print(float)
     */
    @Override
    public void print(float x)
    {
        sb.append(x);
    }

    /* (non-Javadoc)
     * @see java.io.PrintWriter#print(double)
     */
    @Override
    public void print(double x)
    {
        sb.append(x);
    }

    /* (non-Javadoc)
     * @see java.io.PrintWriter#print(char[])
     */
    @Override
    public void print(char[] x)
    {
        sb.append(x);
    }

    /* (non-Javadoc)
     * @see java.io.PrintWriter#print(java.lang.String)
     */
    @Override
    public void print(String x)
    {
        sb.append(x);
    }

    /* (non-Javadoc)
     * @see java.io.PrintWriter#print(java.lang.Object)
     */
    @Override
    public void print(Object x)
    {
        sb.append(x);
    }

    /* (non-Javadoc)
     * @see java.io.PrintWriter#println()
     */
    @Override
    public void println()
    {
        synchronized (lock)
        {
            sb.append(NEW_LINE);
        }
    }

    /* (non-Javadoc)
     * @see java.io.PrintWriter#println(boolean)
     */
    @Override
    public void println(boolean x)
    {
        synchronized (lock)
        {
            sb.append(x).append(NEW_LINE);
        }
    }

    /* (non-Javadoc)
     * @see java.io.PrintWriter#println(char)
     */
    @Override
    public void println(char x)
    {
        synchronized (lock)
        {
            sb.append(x).append(NEW_LINE);
        }
    }

    /* (non-Javadoc)
     * @see java.io.PrintWriter#println(int)
     */
    @Override
    public void println(int x)
    {
        synchronized (lock)
        {
            sb.append(x).append(NEW_LINE);
        }
    }

    /* (non-Javadoc)
     * @see java.io.PrintWriter#println(long)
     */
    @Override
    public void println(long x)
    {
        synchronized (lock)
        {
            sb.append(x).append(NEW_LINE);
        }
    }

    /* (non-Javadoc)
     * @see java.io.PrintWriter#println(float)
     */
    @Override
    public void println(float x)
    {
        synchronized (lock)
        {
            sb.append(x).append(NEW_LINE);
        }
    }

    /* (non-Javadoc)
     * @see java.io.PrintWriter#println(double)
     */
    @Override
    public void println(double x)
    {
        synchronized (lock)
        {
            sb.append(x).append(NEW_LINE);
        }
    }

    /* (non-Javadoc)
     * @see java.io.PrintWriter#println(char[])
     */
    @Override
    public void println(char[] x)
    {
        synchronized (lock)
        {
            sb.append(x).append(NEW_LINE);
        }
    }

    /* (non-Javadoc)
     * @see java.io.PrintWriter#println(java.lang.String)
     */
    @Override
    public void println(String x)
    {
        synchronized (lock)
        {
            sb.append(x).append(NEW_LINE);
        }
    }

    /* (non-Javadoc)
     * @see java.io.PrintWriter#println(java.lang.Object)
     */
    @Override
    public void println(Object x)
    {
        synchronized (lock)
        {
            sb.append(x).append(NEW_LINE);
        }
    }
    
    /* (non-Javadoc)
     * @see java.io.PrintWriter#write(char[])
     */
    @Override
    public void write(char[] buf)
    {
        synchronized (lock)
        {
            sb.append(buf);
        }
    }
    
    /* (non-Javadoc)
     * @see java.io.PrintWriter#write(char[], int, int)
     */
    @Override
    public void write(char[] buf, int off, int len)
    {
        synchronized (lock)
        {
            sb.append(new String(buf, off, len));
        }
    }
    
    /* (non-Javadoc)
     * @see java.io.PrintWriter#write(int)
     */
    @Override
    public void write(int c)
    {
        synchronized (lock)
        {
            sb.append(String.valueOf(c));
        }
    }
    
    /* (non-Javadoc)
     * @see java.io.PrintWriter#write(String)
     */
    @Override
    public void write(String s)
    {
        synchronized (lock)
        {
            sb.append(s);
        }
    }
    
    /* (non-Javadoc)
     * @see java.io.PrintWriter#write(String, int, int)
     */
    @Override
    public void write(String s, int off, int len)
    {
        synchronized (lock)
        {
            sb.append(s.substring(off, off + len));
        }
    }
    
    /* 
     * Since no stream is being written to, this method does nothing.
     */
    @Override
    public void flush() {
        //Do nothing.
    }
    
}
