package com.swx.core.page;

import com.day.cq.wcm.api.Page;
import com.swx.core.page.impl.TestPageImpl;

/**
 * NOTE: This should be modified per project to return the extended version of BasePage, rather than TestPageImpl.
 * @author Patrick Armstrong
 */
public class BasePageFactory {
	
	private Page page;
	
	public BasePageFactory() {
		page = null;
	}
	
	public BasePageFactory withPage(Page page) {
		this.page = page;
		return this;
	}
	
	public BasePage build() {
		if (page == null) {
			return null;
		}
		return new TestPageImpl(page);
	}

}
