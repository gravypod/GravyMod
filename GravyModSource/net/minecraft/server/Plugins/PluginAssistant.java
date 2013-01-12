package net.minecraft.server.Plugins;

import java.util.logging.Logger;

import net.minecraft.server.Plugins.Events.Event;
import net.minecraft.server.Plugins.Events.EventManager;
import net.minecraft.server.Plugins.Events.Listener;
import net.minecraft.server.Plugins.Timer.Timer;
import net.minecraft.server.Plugins.Timer.Times;

/**
 * Assists with using methods provided such as {@link Event} registration
 * @author gravypod
 *
 */
public class PluginAssistant {
	
	/** Event Manager object */
	private final EventManager eventManager;
	
	/** Main Logger that is shown in the GUI */
	private final Logger log;

	private final PluginManager pm;
	
	/**
	 * Create a plugin assistant
	 * @param eventManager - Current servers {@link EventManager} instance
	 * @param logger - Current servers {@link Logger} instance
	 */
	public PluginAssistant(EventManager eventManager, PluginManager pm, Logger logger) {
	
		this.eventManager = eventManager;
		this.pm = pm;
		log = logger;
	}
	
	/**
	 * Register events to a listener class.
	 * @param p - {@link Plugin} you want to register to
	 * @param l
	 */
	public void registerEvents(Plugin p, Listener l) {
	
		try {
			eventManager.registerEvents(p, l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Make an async repeating task.
	 * @param runner - {@Link Runnable} to run
	 * @param time - A time to wait between each run. Use {@link Times}
	 * @return
	 */
	public Timer makeAsyncTimer(Runnable runner, Times time) {
		long timeInLong = time.getTime();
		Timer timer = new Timer(runner, timeInLong, timeInLong);
		return timer;
	}
	
	/**
	 * Get an instance of the current servers {@link Logger}
	 * @return - instance of {@link Logger}
	 */
	public Logger getLogger() {
	
		return log;
	}
	
	/**
	 * Unregister events from a plugin
	 * @param p - {@link Plugin} to remove events from
	 */
	public void unregisterEvents(Plugin p) {
		eventManager.unregisterEvents(p);
	}
	
	/**
	 * Get the {@link EventManager}
	 * @return - Instance of the servers {@link EventManager}
	 */
	public EventManager getEventManager() {
	
		return eventManager;
	}
	
	/**
	 * Get an instance of the plugin manager
	 * @return
	 */
	public PluginManager getPluginManager() {
		return pm;
	}
	
}
