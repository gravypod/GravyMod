package com.gravypod.GravyModPlugin;

import net.minecraft.src.ICommandSender;
import net.minecraft.src.CommandBase;
import net.minecraft.src.EntityPlayerMP;

public class FeedCommand extends CommandBase {

	@Override
    public String getCommandName() {
	    return "feed";
    }

	@Override
    public void processCommand(ICommandSender sender, String[] args) {
		
		EntityPlayerMP player = CommandBase.getCommandSenderAsPlayer(sender);
		player.heal(60);
		player.getFoodStats().addStats(99, 99f);
		
    }
	
}
