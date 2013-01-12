package net.minecraft.server.Plugins.Events.Entity;

import net.minecraft.server.Plugins.Plugin;
import net.minecraft.server.Plugins.Events.Event;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;

/**
 * Fired when an Entity Damages an Entity
 * @author gravypod
 *
 */
public class EntityDamagedByEntity extends Event {
	
	private Entity entity;
	
	private DamageSource damageSource;
	
	private int addedDamage;
	
	/**
	 * 
	 * @param entity
	 * @param damageSource
	 * @param addedDamage
	 *            - Like Blaze and snow-balls
	 */
	public EntityDamagedByEntity(Entity entity, DamageSource damageSource, int addedDamage) {
	
		this.entity = entity;
		this.damageSource = damageSource;
		this.addedDamage = addedDamage;
	}
	
	/**
	 * Damage added by {@link Plugin}s
	 * @return - {@link Integer} of added damage
	 */
	public int getAddedDamage() {
	
		return addedDamage;
	}
	
	/**
	 * Set the damage to be added
	 * @param addedDamage - {@link Integer} of added damage
	 */
	public void setAddedDamage(int addedDamage) {
	
		this.addedDamage = addedDamage;
	}
	
	/**
	 * {@link DamageSource} of this attack
	 * @return
	 */
	public DamageSource getDamageSource() {
	
		return damageSource;
	}
	
	/**
	 * Entity that was attacked
	 * @return - {@link Event}'s instance
	 */
	public Entity getEntity() {
	
		return entity;
	}
	
}
