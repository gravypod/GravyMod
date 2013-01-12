package net.minecraft.server.Plugins.Events.Player;

import net.minecraft.server.Plugins.Events.Event;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayerMP;

/**
 * Fired when ever a player breaks a block
 * @author gravypod
 *
 */
public class BlockBreakEvent extends Event {
	
	/** Block to break */
	private final Block block;
	
	/** Player who wants to break this block */
	private final EntityPlayerMP player;
	
	/**
	 * Create a {@link BlockBreakEvent}
	 * @param player - {@link EntityPlayerMP} who wants to break the block
	 * @param block - {@link Block} the {@link EntityPlayerMP} wants to break
	 */
    public BlockBreakEvent(EntityPlayerMP player, Block block) {
	
		this.block = block;
		this.player = player;
		
	}
	
    /**
     * Get the {@link EntityPlayerMP} of the player who wants to break the block
     * @return - {@link EntityPlayerMP} instance of the player who wants to break the block
     */
	public EntityPlayerMP getPlayer() {
	
		return player;
	}
	
	/**
	 * {@link Block} that the {@link EntityPlayerMP} wants to break
	 * @return - {@link Block} instance
	 */
	public Block getBlock() {
	
		return block;
	}
	
}
