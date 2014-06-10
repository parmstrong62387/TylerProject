package com.swx.core.sitemap;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Patrick Armstrong 
 */
public class SitemapItem {
    
    private int level;
    private ArrayList<SitemapItem> children;
    private String url;
    private String title;
    private String linkClass;
    private SitemapItem parentRef;
    private int totalItemCount;
    
    public SitemapItem() {
        level = 0;
        children = new ArrayList<SitemapItem>();
        url = "";
        title = "";
        linkClass = "";
        parentRef = null;
        totalItemCount = 1;
    }

    public void addChild(SitemapItem child) {
        //Link the child back to the parent
        child.parentRef = this;
        //Increment item counts of the parents
        SitemapItem temp = this;
        while (temp.parentRef != null) {
            temp = temp.parentRef;
            temp.totalItemCount++;
        }
        totalItemCount++;
        this.children.add(child);
    }
    
    public void setLevel(int level) {
        this.level = level;
        this.linkClass = "level" + (level+1);
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public List<SitemapItem> getChildren() {
        return children;
    }

    public int getTotalItemCount() {
        return totalItemCount;
    }

    public int getLevel() {
        return level;
    }

    public String getLinkClass() {
        return linkClass;
    }

    public String getTitle() {
        return title;
    }
    
}