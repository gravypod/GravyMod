package net.minecraft.server.Plugins.Events.Player;

import net.minecraft.server.Plugins.Events.Event;
import net.minecraft.src.EntityPlayerMP;

/**
 * Player Login Event is fired when an {@link EntityPlayerMP} attempts to login
 * @author gravypod
 *
 */
public class PlayerLoginEvent extends Event {
	
	private final EntityPlayerMP player;
	
	private String kickMessage = "";
	
	/**
	 * Create and {@link PlayerLoginEvent}
	 * @param player - {@link EntityPlayerMP} who wants to login
	 */
	public PlayerLoginEvent(EntityPlayerMP player) {
	
		this.player = player;
	}
	
	/**
	 * Get the {@link EntityPlayerMP} attempting to login
	 * @return - {@link EntityPlayerMP} instance
	 */
	public EntityPlayerMP getPlayer() {
	
		return player;
	}
	
	/**
	 * Get the kick message, will be <code>""</code> if the player has not been kicked
	 * @return
	 */
	public String getKickMessage() {
	
		return kickMessage;
	}
	
	@Override
	public void setCancelled(boolean isCancelled) {
		
		if (kickMessage == "") {
			kickMessage = "You have been kicked from the server!";
		}
		
		super.setCancelled(isCancelled);
	}
	
	/**
	 * Set the kick message, must be set after setCancelled
	 * @param kickMessage
	 */
	public void setKickMessage(String kickMessage) {
	
		this.kickMessage = kickMessage;
	}
	
}
