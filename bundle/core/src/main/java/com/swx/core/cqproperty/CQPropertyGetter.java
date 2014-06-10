package com.swx.core.cqproperty;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;



public abstract class CQPropertyGetter {
    
    private Resource resource;
    private ValueMap valueMap;
    
    protected void initialize(Resource resource) throws IllegalAccessException {
     
    }
    
}
