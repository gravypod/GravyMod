package net.minecraft.server.Plugins;

import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Logger;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.Plugins.Events.EventManager;

/**
 * Manages everyday {@link Plugin} functionality. EX Loading, And disabling a plugin
 * @author gravypod
 *
 */
public class PluginManager {
	
	/** {@link MinecraftServer} instance */
	private final MinecraftServer server;
	
	/**{@link Logger} instance */
	private final Logger log;
	
	/** Loaded {@link Plugin} {@link HashMap}. */
	private final HashMap<String, Plugin> loadedPlugins = new HashMap<String, Plugin>();
	
	/** Main {@link EventManager} */
	private final EventManager eventManager = new EventManager();
	
	/** {@link PluginAssistant} manager */
	private final PluginAssistant assistant;
	
	/**
	 * Create a new {@link PluginManager}
	 * @param logger - {@link Logger} instance from the server
	 */
	public PluginManager(Logger logger) {
	
		log = logger;
		
		log.info("Started plugin handler");
		
		server = MinecraftServer.getServer();
		
		assistant = new PluginAssistant(eventManager, log);
		
	}
	
	/**
	 * Load all of the .jar files in ./plugins/ into {@link Plugin} objects
	 * This also runs onEnabled() and init()
	 */
	public void loadPlugins() {
	
		File pluginFolder = new File("./plugins/");
		
		if (!pluginFolder.exists()) {
			pluginFolder.mkdir();
			return;
		}
		
		File[] pluginFiles = pluginFolder.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File arg0, String arg1) {
				
				return arg1.endsWith(".jar");
				
			}
			
		});
		
		for (File plugin : pluginFiles) {
			
			loadPluginFile(plugin);
			
		}
		
	}
	
	/**
	 * Load a jar {@link File} into a {@link Plugin}
	 * @param jar - {@link File} to load into a {@link Plugin}. Must contain a plugin.prop with name and main
	 */
	public void loadPluginFile(File jar) {
	
		try {
			
			JarFile jarFile = new JarFile(jar);
			
			JarEntry jarEntry = jarFile.getJarEntry("plugin.prop");
			
			InputStream is = jarFile.getInputStream(jarEntry);
			
			Properties prop = new Properties();
			
			URL[] urls = new URL[1];
			
			urls[0] = jar.toURI().toURL();
			
			prop.load(is);
			
			String main = prop.getProperty("main");
			
			String name = prop.getProperty("name");
			
			if (main == "" || name == "") {
				throw new Exception("Your plugin did not contain a name or a main in plugin.prop");
			}
			
			Class<?> jarClass = Class.forName(main, true, new GravyModClassLoader(urls, getClass().getClassLoader()));
			
			Class<? extends Plugin> plugin = jarClass.asSubclass(Plugin.class);
			
			Constructor<? extends Plugin> constructor = plugin.getConstructor();
			
			Plugin result = constructor.newInstance();
			
			result.init(assistant, main, name);
			
			result.onEnable(server);
			
			loadedPlugins.put(name, result);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getStackTrace().toString());
		}
		
	}
	
	/**
	 * Disable all {@link Plugin}s
	 */
	public void disablePlugins() {
	
		for (Plugin plugin : loadedPlugins.values()) {
			
			plugin.onDisable(server);
			
		}
		
	}
	
	/**
	 * Disable a plugin by its name
	 * @param name - {@link String} of the plugins name
	 */
	public void disablePlugin(String name) {
		
		Plugin plugin = getPlugin(name);
		
		if (plugin == null) {
			throw new IllegalArgumentException("That plugin is not enabled");
		}
		
		plugin.onDisable(server);
		
		
		
	}
	
	/**
	 * Get a {@link Plugin} by its name
	 * @param name - {@link String} of the {@link Plugin}s name
	 * @return - {@link Plugin} instance of it is loaded, <code>null</code> otherwise
	 */
	public Plugin getPlugin(String name) {
		
		if (!loadedPlugins.containsKey(name)) {
			return null;
		}
		
		return loadedPlugins.get(name);
		
	}
	
	/**
	 * {@link EventManager} instance
	 * @return - {@link EventManager} instance
	 */
	public EventManager getEventManager() {
	
		return eventManager;
	}
	
}
