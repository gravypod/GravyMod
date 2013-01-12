package net.minecraft.server.Plugins.Events.Player;

import net.minecraft.server.Plugins.Events.Event;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

/**
 * Item Use Event fired when a player right-clicks with an {@link Item}/{@link ItemStack}
 * @author gravypod
 *
 */
public class ItemUseEvent extends Event {
	
	private ItemStack itemStack;
	private EntityPlayerMP player;
	
	/**
	 * Create an {@link ItemUseEvent}
	 * @param player - {@link EntityPlayerMP} that fired this event
	 * @param is - {@link ItemStack} the player has in their hand
	 */
	public ItemUseEvent(EntityPlayerMP player, ItemStack is) {
		this.itemStack = is;
		this.player = player;
	}
	
	/**
	 * {@link EntityPlayerMP} instance of the player who fired this event
	 * @return - {@link EntityPlayerMP} instance
	 */
	public EntityPlayerMP getPlayer() {
	    return player;
    }
	
	/**
	 * {@link ItemStack} that will be placed if the {@link Event} is not cancelled
	 * @return - {@link ItemStack} instance
	 */
	public ItemStack getItemStack() {
	
		return itemStack;
	}
	
}
