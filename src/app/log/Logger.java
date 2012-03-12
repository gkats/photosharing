package app.log;

public enum Logger {

	INSTANCE;
	
	public void log(Severity severity, String message) {
		System.out.println("[" + severity + "] " + message);
	}
}