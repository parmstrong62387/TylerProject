package com.swx.core.page;

import com.swx.core.enums.TemplateEnum;
import com.day.cq.dam.api.Asset;
import com.day.cq.wcm.api.Page;

import java.io.IOException;

/**
 *
 * An extension of CQ's page, meant to encapsulate logic such as the preferred way to get 
 * title, description, and other things.
 */
public interface BasePage extends Page {
    
    public TemplateEnum getTemplateEnum();
    
    public String getDomain();
    
    public String getUrl();

    public BasePage getLanguageRoot();
    
    public boolean isAddedToSitemap();
    
    public Asset getThumbnail();
    
    public String getBodyContent() throws IOException;
    
}
