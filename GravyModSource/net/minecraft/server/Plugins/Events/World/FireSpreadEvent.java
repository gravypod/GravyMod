package net.minecraft.server.Plugins.Events.World;

import net.minecraft.server.Plugins.BlockUtil;
import net.minecraft.server.Plugins.Events.Event;
import net.minecraft.src.Block;
import net.minecraft.src.BlockFire;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.World;

/**
 * FireSpreadEvent is fired when a {@link BlockFire} attemps to move
 * @author gravypod
 *
 */
public class FireSpreadEvent extends Event {
	
	private Block fireBlock;
	private ChunkPosition spreadingTo;
	private World world;
	private Block spreadToBlock;
	
	/**
	 * Create a {@link FireSpreadEvent}
	 * @param fire - {@link Block} that is the epicenter of this event
	 * @param world
	 * @param spreadingTo
	 */
    public FireSpreadEvent(Block fire, World world, ChunkPosition spreadingTo) {
    	this.fireBlock = fire;
    	this.spreadingTo = spreadingTo;
    	this.world = world;
    	spreadToBlock = BlockUtil.getBlock(world, spreadingTo);
    } 
    
    /**
     * Block that is on fire
     * @return
     */
    public Block getFireBlock() {
	    return fireBlock;
    }
    
    /**
     * World that this is happening in
     * @return
     */
    public World getWorld() {
    
	    return world;
    }
    
    /**
     * Block it wants to spread to
     * @return
     */
    public Block getSpreadToBlock() {
        
	    return spreadToBlock;
    }
    
    /**
     * Position of where it wants to spead to.
     * @return
     */
    public ChunkPosition getSpreadingTo() {
    
	    return spreadingTo;
    }
    
}
