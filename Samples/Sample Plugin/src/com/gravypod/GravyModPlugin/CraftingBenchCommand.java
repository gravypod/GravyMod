package com.gravypod.GravyModPlugin;

import net.minecraft.src.CommandBase;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.ICommandSender;


public class CraftingBenchCommand extends CommandBase {

	@Override
    public String getCommandName() {
	    return "xp";
    }

	@Override
    public void processCommand(ICommandSender player, String[] arg) {
		
		EntityPlayerMP playerMP = getCommandSenderAsPlayer(player);
		
		if (arg.length == 0) {
			return;
		}
		
		playerMP.addExperienceLevel(Integer.parseInt(arg[0]));
	    
    }

}
