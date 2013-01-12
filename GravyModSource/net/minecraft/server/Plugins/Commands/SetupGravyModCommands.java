package net.minecraft.server.Plugins.Commands;

import net.minecraft.server.Plugins.PluginManager;
import net.minecraft.src.ICommandManager;
import net.minecraft.src.ServerCommandManager;


public class SetupGravyModCommands {
	
	/**
	 * Setup out build in commands
	 * @param iCommandManager
	 * @param pm
	 */
	public static void setup(ICommandManager iCommandManager, PluginManager pm) {
		((ServerCommandManager)iCommandManager).registerCommand(new Plugins(pm));
	}
	
}
