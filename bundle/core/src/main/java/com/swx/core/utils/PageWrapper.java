package com.swx.core.utils;

import java.lang.IllegalArgumentException;
import java.util.Calendar;
import java.util.Locale;
import java.util.Iterator;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.Template;
import com.day.cq.wcm.api.WCMException;
import com.day.cq.tagging.Tag;
import com.day.cq.commons.Filter;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

/** Wrapper for CQ Page.
 *
 * The PageWrapper is a wrapper for any Page delegating all method calls to the wrapped resource by default. Extensions of
 * this class may overwrite any method to return different values as appropriate.
 */
public class PageWrapper implements Page {

    /** The page we're wrapping. */
    private Page wrappedPage = null;

    /** Default constructor */
    public PageWrapper() {}

    /** Constructs a new wrapper.
     *
     * @param wrappedPage the page to wrap
     * @throws IllegalArgumentException if the wrappedPage argument is null
     */
    public PageWrapper(Page wrappedPage) {
        if (wrappedPage == null) {
            throw new IllegalArgumentException("PageWrapper must be constructed with a nonnull page");
        }
        this.wrappedPage = wrappedPage;
    }

    /** Returns the page wrapped by this object. */
    public Page getWrappedPage() {
        return wrappedPage;
    }

    @Override
    public boolean canUnlock() {
        return wrappedPage.canUnlock();
    }

    @Override
    public Page getAbsoluteParent(int level) {
        return wrappedPage.getAbsoluteParent(level);
    }

    @Override
    public Resource getContentResource() {
        return wrappedPage.getContentResource();
    }

    @Override
    public Resource getContentResource(String relPath) {
        return wrappedPage.getContentResource(relPath);
    }

    @Override
    public int getDepth() {
        return wrappedPage.getDepth();
    }

    @Override
    public Locale getLanguage(boolean ignoreContent) {
        return wrappedPage.getLanguage(ignoreContent);
    }

    @Override
    public Calendar getLastModified() {
        return wrappedPage.getLastModified();
    }

    @Override
    public String getLastModifiedBy() {
        return wrappedPage.getLastModifiedBy();
    }

    @Override
    public String getLockOwner() {
        return wrappedPage.getLockOwner();
    }

    @Override
    public String getName() {
        return wrappedPage.getName();
    }

    @Override
    public String getNavigationTitle() {
        return wrappedPage.getNavigationTitle();
    }

    @Override
    public Calendar getOffTime() {
        return wrappedPage.getOffTime();
    }

    @Override
    public Calendar getOnTime() {
        return wrappedPage.getOnTime();
    }

    @Override
    public PageManager getPageManager() {
        return wrappedPage.getPageManager();
    }

    @Override
    public String getPageTitle() {
        return wrappedPage.getPageTitle();
    }

    @Override
    public Page getParent() {
        return wrappedPage.getParent();
    }

    @Override
    public Page getParent(int level) {
        return wrappedPage.getParent(level);
    }

    @Override
    public String getPath() {
        return wrappedPage.getPath();
    }

    @Override
    public ValueMap getProperties() {
        return wrappedPage.getProperties();
    }

    @Override
    public ValueMap getProperties (String relPath) {
        return wrappedPage.getProperties(relPath);
    }

    @Override
    public Tag[] getTags() {
        return wrappedPage.getTags();
    }

    @Override
    public Template getTemplate() {
        return wrappedPage.getTemplate();
    }

    @Override
    public String getTitle() {
        return wrappedPage.getTitle();
    }

    @Override
    public String getVanityUrl() {
        return wrappedPage.getVanityUrl();
    }

    @Override
    public boolean hasChild(String name) {
        return wrappedPage.hasChild(name);
    }

    @Override
    public boolean hasContent() {
        return wrappedPage.hasContent();
    }

    @Override
    public boolean isHideInNav() {
        return wrappedPage.isHideInNav();
    }

    @Override
    public boolean isLocked() {
        return wrappedPage.isLocked();
    }

    @Override
    public boolean isValid() {
        return wrappedPage.isValid();
    }

    @Override
    public Iterator<Page> listChildren() {
        return wrappedPage.listChildren();
    }

    @Override
    public Iterator<Page> listChildren(Filter<Page> filter) {
        return wrappedPage.listChildren(filter);
    }

    @Override
    public Iterator<Page> listChildren(Filter<Page> filter, boolean deep) {
        return wrappedPage.listChildren(filter, deep);
    }

    @Override
    public void lock() throws WCMException {
        wrappedPage.lock();
    }

    @Override
    public long timeUntilValid() {
        return wrappedPage.timeUntilValid();
    }

    @Override
    public void unlock() throws WCMException {
        wrappedPage.unlock();
    }

    @Override
    public <AdapterType> AdapterType adaptTo(Class<AdapterType> type) {
        return wrappedPage.adaptTo(type);
    }

    @Override
    public String getDescription() {
        return wrappedPage.getDescription();
    }

}