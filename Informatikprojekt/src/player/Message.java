package player;

public class Message {

	public static String displayMessage = "";
	
	public static long dampenersOnTime = -1;
	public static long dampenersOffTime = -1;
	public static String dampenerOnMessage = "Intertial Dampeners: Enabled";
	public static String dampenerOffMessage = "Intertial Dampeners: Disabled";
	
	public static void handleMessages() {
		if(dampenersOnTime != -1 && System.currentTimeMillis() - dampenersOnTime < 2000) {
			displayMessage = dampenerOnMessage;
		}
		if(dampenersOffTime != -1 && System.currentTimeMillis() - dampenersOffTime < 2000) {
			displayMessage = dampenerOffMessage;
		}
	}
}
