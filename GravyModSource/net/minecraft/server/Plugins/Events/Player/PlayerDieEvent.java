package net.minecraft.server.Plugins.Events.Player;

import net.minecraft.server.Plugins.Events.Event;
import net.minecraft.src.DamageSource;
import net.minecraft.src.EntityPlayer;

/**
 * Fired when a {@link EntityPlayer} dies
 * Not Yet Implemented
 * @author gravypod
 *
 */
public class PlayerDieEvent extends Event {
	
	private final EntityPlayer player;
	private final DamageSource damageSource;
	
	/**
	 * Create a {@link PlayerDieEvent}
	 * @param player - {@link EntityPlayer} who is going to die
	 * @param damageSource - {@link DamageSource} that caused the death
	 */
	public PlayerDieEvent(EntityPlayer player, DamageSource damageSource) {
		this.player = player;
		this.damageSource = damageSource;
	}
	
	/**
	 * {@link DamageSource} that  is going to kill the {@link EntityPlayer}
	 * @return - {@link DamageSource} instance
	 */
	public DamageSource getDamageSource() {
	    return damageSource;
    }
    
	/**
	 * {@link EntityPlayer} that  will die if the event is not cancelled
	 * @return - {@link EntityPlayer} instance
	 */
    public EntityPlayer getPlayer() {
	    return player;
    }
    
}
