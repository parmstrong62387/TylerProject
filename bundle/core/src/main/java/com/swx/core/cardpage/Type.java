package com.swx.core.cardpage;

public enum Type {
	ASSAULT("Assualt"),
	STRUCTURE("Structure"),
	COMMANDER("Commander");

	Type(String path){
		
	}
	
	public static Type getType(String path) {
	    return(ASSAULT);
	}
}