package com.swx.core.page.impl;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;

import com.day.cq.dam.api.Asset;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.foundation.Image;
import com.sun.mail.handlers.image_gif;
import com.swx.core.enums.TemplateEnum;
import com.swx.core.page.BasePage;
import com.swx.core.utils.PageWrapper;

public abstract class BasePageImpl extends PageWrapper implements BasePage {
    
    public BasePageImpl(Page page) {
        super(page);
    }
    
    @Override
    public TemplateEnum getTemplateEnum() {
		return TemplateEnum.getTemplateEnum(getProperties().get("cq:template", ""));
    }

    @Override
    public abstract String getDomain();
    
    @Override
    public abstract String getUrl();

    @Override
    public BasePage getLanguageRoot() {
    	return null;
    }

    @Override
    public abstract boolean isAddedToSitemap();
    
    @Override
    public Asset getThumbnail() {
    	Resource res = getContentResource("image");
    	return res.adaptTo(Asset.class);
    }
    
    @Override
    public abstract String getBodyContent();
    
}
