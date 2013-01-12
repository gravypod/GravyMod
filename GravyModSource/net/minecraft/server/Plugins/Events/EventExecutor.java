package net.minecraft.server.Plugins.Events;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * {@link EventExecutor} created for every {@link Method} found in a {@link Listener} with the {@link EventManager} {@link Annotation}
 * @author gravypod
 *
 */
public class EventExecutor {
	
	private final Listener listener;
	private final Method method;
	private final boolean ignore;
	
	/**
	 * Create an {@link EventExecutor}
	 * @param listener - {@link Listener} object instance
	 * @param method - {@link Method} to pass the {@link Event}s to.
	 * @param ignore - {@link Boolean} to signify you have do/nt want to listen to an {@link Event} if it is cancelled
	 */
    public EventExecutor(Listener listener, Method method, boolean ignore) {
    	
    	this.listener = listener;
    	
    	this.method = method;
    	
    	this.ignore = ignore;
    	
    }
	
    /**
     * Execute an event on this listener
     * @param event - {@link Event} object
     */
    public void execute(Event event) {
    	try {
    		
    		if (ignore && event.isCancelled()) { // Dont pass events that are cancelled if you ignore them
    			return;
    		}
    		
    		method.invoke(listener, event);
    		
    	} catch (IllegalAccessException e) {
	        e.printStackTrace();
        } catch (IllegalArgumentException e) {
	        e.printStackTrace();
        } catch (InvocationTargetException e) {
	        e.printStackTrace();
        }
    }
    
}
