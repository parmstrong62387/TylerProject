package com.swx.core.leftnav;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.day.cq.wcm.api.Page;

public class LeftNav {
	
	private List<LeftNavItem> list;
	public LeftNav(Page page) {
		list = new ArrayList<LeftNavItem>();
		Page root = page.getAbsoluteParent(1);
		if (root != null) {
			Iterator<Page> toplevel = root.listChildren();
			while (toplevel.hasNext()) {
				Page parent = toplevel.next();
				list.add(new LeftNavItem(parent, 0));
				Iterator<Page> child = parent.listChildren();
				while (child.hasNext()) {
					list.add(new LeftNavItem(child.next(), 1));
				}
			}
		}
	}
	
	public List<LeftNavItem> getItems() {
		return list;
	}
	
}
