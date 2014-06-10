package com.swx.core.enums;

public enum TemplateEnum {
	EMPTY_T("");

	TemplateEnum(String path){
		
	}
	
	public static TemplateEnum getTemplateEnum(String path) {
	    return(EMPTY_T);
	}
}
