package net.minecraft.server.Plugins.Commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.server.Plugins.PluginManager;
import net.minecraft.src.CommandBase;
import net.minecraft.src.ICommandSender;

public class Plugins extends CommandBase {
	
	private final List<String> alias = new ArrayList<String>();
	private final PluginManager pm;
	
    public Plugins(PluginManager pm) {
    	alias.add("pl");
    	this.pm = pm;
    }
	
    @Override
    public List<String> getCommandAliases() {
    	return alias;
    }
    
	@Override
    public String getCommandName() {
	    return "plugins";
    }

	@Override
    public void processCommand(ICommandSender sender, String[] args) {
		sender.sendChatToPlayer(pm.getEnabledPluginsNames().toString());
    }
	
}
