package com.swx.core.tags;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;

public class AnchorTag extends TagSupport implements DynamicAttributes {
    
	private static final long serialVersionUID = 5614673099924009143L;
	private String href = null;
    private boolean isValidHref;
    
    private Map<String,Object> tagAttributes = new HashMap<String,Object>();
    
    @Override
    public int doStartTag() throws JspException {
        
        ResourceResolver resourceResolver = (ResourceResolver)pageContext.getAttribute("resourceResolver");
        isValidHref = true;
        
        if (href == null || href.isEmpty()) {
            isValidHref = false;
        } else if (Pattern.matches("(/[\\w\\-]+)+", href)) {
            Resource res = resourceResolver.getResource(href);
            if (res == null) {
                isValidHref = false;
            } else {
            	href = resourceResolver.map(href);
            }
        }
        
        if (isValidHref) {
            StringBuilder sb = new StringBuilder();
            sb.append("<a href=\"").append(resourceResolver).append("\"");
            for (Map.Entry<String,Object> entry : tagAttributes.entrySet()) {
                sb.append(" ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
            }
            sb.append(">");
            
            try {
                if (isValidHref) {
                    pageContext.getOut().print(sb.toString());
                }
            } catch (IOException e) {
                throw new JspException(e);
            }
        }
        
        return EVAL_BODY_INCLUDE;
    }
    
    @Override
    public int doEndTag() throws JspException  {
        try {
            if (isValidHref) {
                pageContext.getOut().print("</a>");
            }
        } catch (IOException e) {
            throw new JspException(e);
        }
        return SKIP_BODY;
    }
    
    @Override
    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {  
        tagAttributes.put(localName, value);
    }
    
    public void setHref(String href) {
        this.href = href;
    }
    
}