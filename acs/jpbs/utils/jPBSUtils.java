package acs.jpbs.utils;

import java.util.Arrays;

public class jPBSUtils {
	
	private jPBSUtils() { }
	
	public static <T> T[] concat(T[] first, T[] second) {
		T[] result = Arrays.copyOf(first, first.length + second.length);
		System.arraycopy(second, 0, result, first.length, second.length);
		return result;
	}
	
	public static String join(String[] arr, String glue) {
		if(arr.length < 1) return "";
		else if(arr.length == 1) return arr[0];
		else {
			StringBuilder bucket = new StringBuilder();
			for(String s : Arrays.copyOf(arr, arr.length-1)) {
				bucket.append(s);
				bucket.append(glue);
			}
			bucket.append(arr[arr.length-1]);
			return bucket.toString();
		}
	}

}
