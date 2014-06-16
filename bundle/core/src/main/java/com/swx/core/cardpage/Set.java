package com.swx.core.cardpage;

public enum Set {
	STANDARD("Standard"),
	REWARD("Reward"),
	EVENT("Event"),
	FUSION("Fusion");

	Set(String path){
		
	}
	
	public static Set getSet(String path) {
	    return(STANDARD);
	}
}