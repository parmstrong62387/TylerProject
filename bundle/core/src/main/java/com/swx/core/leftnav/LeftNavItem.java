package com.swx.core.leftnav;
import com.day.cq.wcm.api.Page;

public class LeftNavItem {

	private int level;
	private String link, title;
	public LeftNavItem(Page page, int x) {
		title = page.getTitle();
		link = page.getPath() + ".html";
		level = x;
	}
	
	public String getLink() {
		return link;
	}
	
	public int getLevel() {
		return level;
	}
	
	public String getTitle() {
		return title;
	}
	
}