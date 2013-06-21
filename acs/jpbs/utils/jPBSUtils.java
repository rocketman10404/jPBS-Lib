package acs.jpbs.utils;

import java.util.Arrays;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;

public class jPBSUtils {
	
	private jPBSUtils() { }
	
	public static <T> T[] concat(T[] first, T[] second) {
		T[] result = Arrays.copyOf(first, first.length + second.length);
		System.arraycopy(second, 0, result, first.length, second.length);
		return result;
	}
	
	/*
	 * Returns Duration object representing String input of form "HH:MM:SS"
	 */
	public static Duration getHMSDuration(String hms) {
		String[] nums = hms.split(":");
		if(nums.length != 3) return null;
		int[] ints = new int[3];
		for(int i=0; i<3; i++) {
			ints[i] = Integer.parseInt(nums[i]);
		}
		try {
			return DatatypeFactory.newInstance().newDuration(true, 0, 0, 0, ints[0], ints[1], ints[2]);
		} catch (DatatypeConfigurationException e) {
			jPBSLogger.logException("Error converting '"+hms+"' to duration", e);
			return null;
		}
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
