package com.gravypod.GravyModPlugin;

import net.minecraft.src.CommandBase;
import net.minecraft.src.ICommandSender;



public class TestingCommand extends CommandBase {

	@Override
    public String getCommandName() {
	    return "testing";
    }

	@Override
    public void processCommand(ICommandSender arg0, String[] arg1) {
		
	    arg0.sendChatToPlayer("This is a test");
    }
	
}
