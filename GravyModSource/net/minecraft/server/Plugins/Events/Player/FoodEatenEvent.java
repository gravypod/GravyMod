package net.minecraft.server.Plugins.Events.Player;

import net.minecraft.server.Plugins.Events.Event;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

/**
 * Fired when a {@link EntityPlayer} attempts to eat food
 * @author gravypod
 *
 */
public class FoodEatenEvent extends Event {
	
	private final ItemStack itemStack;
	
	private final World world;
	
	private final EntityPlayer entityPlayer;
	
	/**
	 * Create a {@link FoodEatenEvent}
	 * @param itemStack
	 * @param world
	 * @param entityPlayer
	 */
	public FoodEatenEvent(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		this.itemStack = itemStack;
		this.world = world;
		this.entityPlayer = entityPlayer;
	}
	
	/**
	 * The {@link EntityPlayer} who fired the event
	 * @return - {@link EntityPlayer} instance
	 */
	public EntityPlayer getEntityPlayer() {
		return entityPlayer;
	}
	
	/**
	 * The {@link ItemStack} of the food that will be eaten if the {@link Event} is not cancelled
	 * @return - {@link ItemStack} instance
	 */
	public ItemStack getItemStack() {
		return itemStack;
	}
	
	/**
	 * The world that this is occurring in
	 * @return - {@link World} instance
	 */
	public World getWorld() {
		return world;
	}
	
}
