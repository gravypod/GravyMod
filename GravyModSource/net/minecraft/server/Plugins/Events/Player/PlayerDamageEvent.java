package net.minecraft.server.Plugins.Events.Player;

import net.minecraft.server.Plugins.Events.Event;
import net.minecraft.src.DamageSource;
import net.minecraft.src.EntityPlayer;

/**
 * PlayerDamageEvent is fired when a player takes damage
 * @author gravypod
 *
 */
public class PlayerDamageEvent extends Event {
	
	private final EntityPlayer entity;
	
	private final DamageSource damageSource;
	
	/**
	 * Create a {@link PlayerDamageEvent}
	 * @param damageSource
	 * @param entity
	 */
	public PlayerDamageEvent(DamageSource damageSource, EntityPlayer entity) {
	
		this.entity = entity;
		this.damageSource = damageSource;
	}
	
	/**
	 * How the player was hurt
	 * @return
	 */
	public DamageSource getDamageSource() {
	
		return damageSource;
	}
	
	/**
	 * {@link EntityPlayer} that was hurt
	 * @return
	 */
	public EntityPlayer getEntity() {
	
		return entity;
	}
	
}
