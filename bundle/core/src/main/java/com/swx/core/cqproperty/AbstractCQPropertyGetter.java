package com.swx.core.cqproperty;

import java.lang.reflect.Field;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Patrick Armstrong
 */
public abstract class AbstractCQPropertyGetter {
    
    private Resource resource;
    private ValueMap valueMap;
    
    private static final Logger log = LoggerFactory.getLogger(AbstractCQPropertyGetter.class);
    
    protected void initialize(Resource resource) throws IllegalAccessException {
        this.resource = resource;
        if (resource != null) {
            this.valueMap = this.resource.adaptTo(ValueMap.class);
        }
        setProperties();
    }
    
    private void setProperties() throws IllegalAccessException {
        if (resource == null || valueMap == null) {
            return;
        }
        for (Field field : getClass().getDeclaredFields()) {
            CQProperty cqProperty = field.getAnnotation(CQProperty.class);
            if (cqProperty != null) {
                Class clazz = field.getType();
                String relPath = cqProperty.relPath();
                field.set(this, valueMap.get(relPath, clazz));
            }
        }
    }
    
}
