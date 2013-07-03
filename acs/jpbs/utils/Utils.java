package acs.jpbs.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;

public class Utils {
	
	private static Pattern numbers = Pattern.compile("[0-9]+");
	
	private Utils() { }
	
	public static <T> T[] concat(T[] first, T[] second) {
		if(first == null) return second;
		else if(second == null) return first;
		T[] result = Arrays.copyOf(first, first.length + second.length);
		System.arraycopy(second, 0, result, first.length, second.length);
		return result;
	}
	
	/*
	 * Attempts to contruct and return a valid URI object from a typical PBS reported path
	 * i.e. node.example.com:/file/path/job.o1234
	 */
	public static URI constructURI(String rawPath) {
		String[] rawParts = rawPath.split(":");
		
		try {
			return new URI("file", rawParts[0], rawParts[1], null);
		} catch (URISyntaxException e) {
			Logger.logException("Unable to determine URI for path '"+rawPath+"'", e);
			return null;
		}
	}
	
	/*
	 * Attempts to parse date object from string, returns null if unsuccessful
	 */
	public static Date dateHelper(String rawDate) {
		try {
			return DateFormat.getInstance().parse(rawDate, new ParsePosition(3));
		} catch (Exception e) {
			Logger.logError("Unable to parse valid date from string '"+rawDate+"'");
			return null;
		}
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
			Logger.logException("Error converting '"+hms+"' to duration", e);
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

	public static int parseId(String sId) {
		int jId = 0;
		String idResult = null;
		Matcher idNum = numbers.matcher(sId);
		if(idNum.find()) {
			idResult = idNum.group();
		}
		if(idResult == null) return jId;
		else {
			jId = Integer.parseInt(idResult);
		}
		return jId;
	}
}
