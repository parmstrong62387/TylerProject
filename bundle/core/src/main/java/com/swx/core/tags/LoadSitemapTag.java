package com.swx.core.tags;

import com.swx.core.page.BasePage;
import com.swx.core.page.BasePageFactory;
import com.swx.core.sitemap.Sitemap;
import com.day.cq.wcm.api.Page;
import java.util.Iterator;
import javax.servlet.jsp.JspException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoadSitemapTag extends BaseTag {
    
	private static final long serialVersionUID = 7297366967947899727L;
    
    protected static Logger log = LoggerFactory.getLogger(LoadSitemapTag.class);

    private String var;
    private int depth;
    private int numColumns;
    private Page parent;
    
    @Override
    public int doStartTag() throws JspException {
        
        Sitemap sitemap = loadSitemap();
        
        log.debug("SITEMAP PRINTOUT: {}", sitemap.toString());
        
        pageContext.setAttribute(var, sitemap);
        
        return super.doStartTag();
    }
    
    public void setVar(String var) {
        this.var = var;
    }
    
    public void setDepth(int depth) {
        this.depth = depth;
    }
    
    public void setNumColumns(int numColumns) {
    	this.numColumns = numColumns;
    }
    
    public void setParent(Page parent) {
    	this.parent = parent;
    }
    
    private Sitemap loadSitemap() {
        Sitemap sitemap = new Sitemap(depth, numColumns);
        if (parent == null) {
            return sitemap;
        }
        Iterator<Page> children = parent.listChildren();
        while (children.hasNext()) {
            BasePage child = new BasePageFactory().withPage(children.next()).build();
            sitemap.addPage(child);
        }
        return sitemap;
    }
    
}