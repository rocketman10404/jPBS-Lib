package acs.jpbs.utils;

public class Logger {
	
	private Logger() { }
	
	public static void logError(String error) {
		System.out.println("[ERROR] "+error);
	}
	
	public static void logException(String error, Exception e) {
		System.out.println("[ERROR] "+error);
		e.printStackTrace();
	}
	
	public static void logInfo(String info) {
		System.out.println("[INFO] "+info);
	}
}
