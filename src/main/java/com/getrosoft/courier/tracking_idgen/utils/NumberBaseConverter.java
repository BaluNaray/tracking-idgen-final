package com.getrosoft.courier.tracking_idgen.utils;

public class NumberBaseConverter {
	
	public static long base36toBase10(String base36) {
        return Long.parseLong(base36, 36);
    }
	
	public static String base10toBase36(long base10) {
		return Long.toString(base10, 36).toUpperCase();
	}	
	
}
