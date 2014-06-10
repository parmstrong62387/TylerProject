package com.swx.core.utils;

import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.Rendition;
import com.day.cq.dam.api.RenditionPicker;
import com.day.cq.dam.api.Revision;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.sling.api.resource.Resource;

/**
 *
 * @author Patrick Armstrong
 */
public class AssetWrapper implements Asset {
    
    private Asset asset;
    
    public AssetWrapper() {}
    
    public AssetWrapper(Asset asset) {
        if (asset == null) {
            throw new IllegalArgumentException("AssetWrapper must be called on a non-null asset.");
        }
        this.asset = asset;
    }
    
    public Asset getWrappedAsset() {
        return asset;
    }

    @Override
    public String getPath() { 
        return asset.getPath();
    }

    @Override
    public String getName() { 
        return asset.getName();
    }

    @Override
    public String getMetadataValue(String name) { 
        return asset.getMetadataValue(name);
    }

    @Override
    public Object getMetadata(String name) { 
        return asset.getMetadata(name);
    }

    @Override
    public long getLastModified() { 
        return asset.getLastModified();
    }

    @Override
    public Rendition getRendition(String name) { 
        return asset.getRendition(name);
    }

    @Override
    public Rendition getOriginal() { 
        return asset.getOriginal();
    }

    @Override
    public Rendition getCurrentOriginal() { 
        return asset.getCurrentOriginal();
    }

    @Override
    public boolean isSubAsset() { 
        return asset.isSubAsset();
    }

    @Override
    public Map<String, Object> getMetadata() {
        return asset.getMetadata();
    }

    @Override
    public Resource setRendition(String name, InputStream is, String mimeType) { 
        return asset.setRendition(name, is, mimeType);
    }

    @Override
    public void setCurrentOriginal(String name) { 
        asset.setCurrentOriginal(name);
    }

    @Override
    public Revision createRevision(String label, String comment) throws Exception { 
        return asset.createRevision(label, comment);
    }

    @Override
    public List<Rendition> getRenditions() {
        return asset.getRenditions();
    }

    @Override
    public Iterator<Rendition> listRenditions() {
        return asset.listRenditions();
    }

    @Override
    public Rendition getRendition(RenditionPicker picker) { 
        return asset.getRendition(picker);
    }

    @Override
    public String getModifier() { 
        return asset.getModifier();
    }

    @Override
    public Asset restore(String revisionId) throws Exception { 
        return asset.restore(revisionId);
    }

    @Override
    public Collection<Revision> getRevisions(Calendar cal) throws Exception {
        return asset.getRevisions(cal);
    }

    @Override
    public String getMimeType() { 
        return asset.getMimeType();
    }

    @Override
    public Rendition addRendition(String name, InputStream is, String mimeType) { 
        return asset.addRendition(name, is, mimeType);
    }

    @Override
    public Asset addSubAsset(String name, String mimeType, InputStream stream) { 
        return asset.addSubAsset(name, mimeType, stream);
    }

    @Override
    public Collection<Asset> getSubAssets() {
        return asset.getSubAssets();
    }

    @Override
    public void removeRendition(String name) { 
        asset.removeRendition(name);
    }

    @Override
    public void setBatchMode(boolean mode) { 
        asset.setBatchMode(mode);
    }

    @Override
    public boolean isBatchMode() { 
        return asset.isBatchMode();
    }

    @Override
    public <AdapterType> AdapterType adaptTo(Class<AdapterType> type) {
        return asset.adaptTo(type);
    }
    
}
