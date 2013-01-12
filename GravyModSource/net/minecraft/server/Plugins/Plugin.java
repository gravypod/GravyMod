package net.minecraft.server.Plugins;

import net.minecraft.server.MinecraftServer;

/**
 * 
 * Extend this in your main class to make your plug-in run!
 * 
 * @author gravypod
 * 
 */
public abstract class Plugin {
	
	private PluginAssistant assistant;
	private String name;
	private String mainClass;
	
	protected void init(PluginAssistant assistant, String mainClass, String name) {
		this.assistant = assistant;
		this.name = name;
	}
	
	/**
	 * 
	 * This gets run when your plug-in starts up
	 * 
	 */
	public void onEnable(MinecraftServer server) {
	
	}
	
	/**
	 * 
	 * This gets run when your plug-in ends
	 * 
	 */
	public void onDisable(MinecraftServer server) {
	
	}
	
	/**
	 * PluginAssistant object to help with some plugin functions
	 * @return - {@link PluginAssistant}
	 */
	public PluginAssistant getAssistant() {
	
		return assistant;
	}
	
	/**
	 * Get the {@link Plugin}'s name
	 * @return - {@link String} of the {@link Plugin}'s name
	 */
    public String getName() {
    
	    return name;
    }
    
    /**
     * Get the main class of this {@link Plugin}
     * @return - {@link String} representing the main {@link Class} of the {@link Plugin}
     */
    public String getMainClass() {
    
	    return mainClass;
    }
	
}
