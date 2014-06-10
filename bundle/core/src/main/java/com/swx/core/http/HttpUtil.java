package com.swx.core.http;

import com.swx.core.io.StringPrintWriter;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Patrick Armstrong
 */
public class HttpUtil {
    
    /**
     * Uses a RequestDispatcher's include method on a CustomHttpServletResponse to include a response into a StringPrintWriter.
     * @param request An HttpServletRequest object.
     * @param response An HttpServletResponse object.
     * @param path The path to include.
     * @return The result of rendering the request.
     * @throws ServletException
     * @throws IOException 
     */
    public static String renderRequestToString(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
        String result = null;
        StringPrintWriter writer = null;
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        CustomHttpServletResponse chsr = new CustomHttpServletResponse(response);
        writer = chsr.getStringPrintWriter();
        
        requestDispatcher.include(request, chsr);
        result = writer.getWrittenContents();
        writer.clear();
        
        return result;
    }
    
}
