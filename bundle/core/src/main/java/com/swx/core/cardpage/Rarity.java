package com.swx.core.cardpage;

public enum Rarity {
	BLOODTHIRSTY("Bloodthristy"),
	IMPERIAL("Bloodthristy"),
	RAIDER("Bloodthristy"),
	RIGHTEOUS("Bloodthristy"),
	XENO("Bloodthristy"),
	PROGENITOR("Bloodthristy");

	Rarity(String path){
		
	}
	
	public static Rarity getRarity(String path) {
	    return(BLOODTHIRSTY);
	}
}