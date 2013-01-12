package net.minecraft.server.Plugins.Events;

import java.util.HashMap;

import net.minecraft.server.Plugins.Plugin;

/**
 * Tracker of all EventExecutors for each event
 * 
 * Notes:
 * 	- All events are fired in this order: HIGH, MEDIUM, LOW, MONITOR
 * 	- MEDIUM is the default {@link EventPriority}
 * 	- Cancelled on MONITOR will not be saved, NEVER CHANGE ON MONITOR! It is for getting the final state of the event
 * 
 * @author gravypod
 *
 */
public class EventHandlerList {
	
	public final HashMap<String, EventExecutor> LOW = new HashMap<String, EventExecutor>(); // Run on different priorities
	public final HashMap<String, EventExecutor> MEDIUM = new HashMap<String, EventExecutor>();
	public final HashMap<String, EventExecutor> HIGH = new HashMap<String, EventExecutor>();
	public final HashMap<String, EventExecutor> MONITOR = new HashMap<String, EventExecutor>();
	
	/**
	 * Add a listener into the {@link EventHandlerList}
	 * @param p - {@link Plugin} that owns this even
	 * @param ee - {@link EventExecutor} for this event
	 * @param ep - {@link EventPriority} to listen on
	 */
	public void addListener(Plugin p, EventExecutor ee, EventPriority ep) {
		
		final String mainClass = p.getMainClass();
		
		switch (ep) {
			
			case LOW:
				LOW.put(mainClass, ee);
				break;
			case MEDIUM:
				MEDIUM.put(mainClass, ee);
				break;
			case HIGH:
				HIGH.put(mainClass, ee);
				break;
			case MONITOR:
				MONITOR.put(mainClass, ee);
				break;
			default:
				throw new IllegalArgumentException("That was not a real event priority!");
			
		}
		
	}
	
	/**
	 * Fire an {@link Event} to all {@link EventExecutor} that this {@link EventHandlerList} knows about
	 * @param event - {@link Event} instance fo pass
	 */
	public void fireEvent(Event event) {
		
		for (EventExecutor ee : HIGH.values()) {
			
			ee.execute(event);
		}
		
		for (EventExecutor ee : MEDIUM.values()) {
			ee.execute(event);
		}
		
		for (EventExecutor ee : LOW.values()) {
			ee.execute(event);
		}
		
		boolean cancelledState = event.isCancelled(); // TODO: Upgrade this for more protection
		
		for (EventExecutor ee : MONITOR.values()) {
			ee.equals(event);
		}
		
		event.setCancelled(cancelledState);
		
	}
	
	/**
	 * Check to see if a {@link Plugin} has an {@link EventExecutor} registered with this {@link EventHandlerList}
	 * @param p - {@link Plugin} to register with
	 * @return - {@link Boolean} <code>true</code> if we contain a listener for it. <code>false</code> otherwise
	 */
	public boolean isRgistered(Plugin p) {
		
		final String mainClass = p.getMainClass();
		
		return LOW.containsKey(mainClass) || HIGH.containsKey(mainClass) || MEDIUM.containsKey(mainClass) || MONITOR.containsKey(mainClass);
	}
	
	public void unregisterEvents(Plugin p) {
		
		final String mainClass = p.getMainClass();
		
		if (LOW.containsKey(mainClass)) {
			LOW.remove(mainClass);
		}
		if (MEDIUM.containsKey(mainClass)) {
			MEDIUM.remove(mainClass);
		}
		if (HIGH.containsKey(mainClass)) {
			HIGH.remove(mainClass);
		}
		if (MONITOR.containsKey(mainClass)) {
			MONITOR.remove(mainClass);
		}
	}
	
}
