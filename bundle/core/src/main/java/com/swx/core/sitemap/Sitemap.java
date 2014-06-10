package com.swx.core.sitemap;

import com.swx.core.page.BasePage;
import com.swx.core.page.BasePageFactory;
import com.day.cq.wcm.api.Page;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Patrick Armstrong
 */
public class Sitemap {
    
    private static final String LINE_BREAK = "\r\n";
    private static final String INDENT = "\t";
    protected static Logger log = LoggerFactory.getLogger(Sitemap.class);

    private ArrayList<SitemapItem> items;
    private int numColumns;
    private ArrayList<ArrayList<SitemapItem>> columns;
    private boolean columnsUpToDate = false;
    private int depth;
    
    public Sitemap(int depth, int numColumns) {
    	if (depth < 0 || numColumns < 1) {
    		throw new IllegalArgumentException("Depth must be greater than or equal to zero, numColumns must be at least one.");
    	}
        items = new ArrayList<SitemapItem>();
        columns = new ArrayList<ArrayList<SitemapItem>>();
        for (int i = 0; i < numColumns; i++) {
        	columns.add(new ArrayList<SitemapItem>());
        }
        this.depth = depth;
    }
    
    public void addPage(BasePage page) {
        if (page == null) {
            return;
        }
        addPage(page, null, 0);
    }
    
    private void addPage(BasePage page, SitemapItem parentItem, int level) {
        if (page.isAddedToSitemap() && !StringUtils.isEmpty(page.getTitle())) {
            SitemapItem sitemapItem = new SitemapItem();
            sitemapItem.setLevel(level);
            sitemapItem.setTitle(page.getTitle());
            sitemapItem.setUrl(page.getUrl());
            if (parentItem != null) {
                parentItem.addChild(sitemapItem);
            }
            if (level < depth) {
                Iterator<Page> children = page.listChildren();
                while (children.hasNext()) {
                    BasePage childPage = new BasePageFactory().withPage(children.next()).build();
                    if (childPage == null) {
                        continue;
                    }
                    addPage(childPage, sitemapItem, level + 1);
                }
            }
            if (level == 0) {
                addSitemapItem(sitemapItem);
            }
        }
    }
    
    private void addSitemapItem(SitemapItem sitemapItem) {
        items.add(sitemapItem);
        columnsUpToDate = false;
    }
    
    private void organizeIntoColumns() {
        if (columnsUpToDate) {
            return;
        }
        for (int i = 0; i < columns.size(); i++) {
    		columns.get(i).clear();
        }
        int totalCount = 0;
        for (int i = 0; i < items.size(); i++) {
            totalCount += items.get(i).getTotalItemCount();
        }
        int amountAddedToCurrentColumn = 0, currentColumnNumber = 0;
        for (int i = 0; i < items.size(); i++) {
            SitemapItem currentItem = items.get(i);
            amountAddedToCurrentColumn += currentItem.getTotalItemCount();
            columns.get(currentColumnNumber).add(currentItem);
            if (currentColumnNumber != numColumns - 1 && ((double)amountAddedToCurrentColumn / totalCount) > (1.0 / numColumns)) {
                amountAddedToCurrentColumn = 0;
            }
        }
        columnsUpToDate = true;
    }
    
    public List<List<SitemapItem>> getColumns() {
        organizeIntoColumns();
        List<List<SitemapItem>> retVal = new ArrayList<List<SitemapItem>>();
        retVal.addAll(columns);
        return retVal;
    }
    
    public List<SitemapItem> getAllItems() {
        return items;
    }
    
    @Override
    public String toString() {
        organizeIntoColumns();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < numColumns; i++) {
	        sb.append("Column ").append(i).append(LINE_BREAK);
	        addItemsToStringBuilder(columns.get(i), sb);
        }
        
        return sb.toString();
    }
    
    private void addItemsToStringBuilder(List<SitemapItem> items, StringBuilder sb) {
        for (SitemapItem item : items) {
            for (int i = 0; i < item.getLevel(); i++) {
                sb.append(INDENT);
            }
            sb.append(item.getTitle()).append(" (").append(item.getTotalItemCount()).append(")").append(LINE_BREAK);
            addItemsToStringBuilder(item.getChildren(), sb);
        }
    }
}
