package net.minecraft.server.Plugins.Timer;

public enum Times {
	
	ONE_SECOND(1000L), ONE_MINUTE(1000L * 60L), ONE_HOUR((1000L * 60L) * 60L), ONE_DAY(((1000L * 60L) * 60L) * 24L), ONE_GREG_WEEK((((1000L * 60L) * 60L) * 24L) * 7L);
	
	private final long time;
	
	private Times(long time) {
	
		this.time = time;
		
	}
	
	public long getTime() {
	
		return time;
		
	}
	
}
