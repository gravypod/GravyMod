package net.minecraft.server.Plugins.Events.World;

import net.minecraft.server.Plugins.BlockUtil;
import net.minecraft.server.Plugins.Events.Event;
import net.minecraft.src.Block;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.World;

/**
 * Not implemented correctly
 * TODO: Finish
 * @author gravypod
 *
 */
public class PistonPullBlockEvent extends Event {
	
	private World world;
	private ChunkPosition chunkCoordinates;
	
    public PistonPullBlockEvent(World world, ChunkPosition chunkCoordinates) {
    	this.world = world;
    	this.chunkCoordinates = chunkCoordinates;
    }
	
    public World getWorld() {
    
	    return world;
    }
    
    public Block getBlockPulled() {
    	return BlockUtil.getBlock(world, chunkCoordinates);
    }
    
    public ChunkPosition getChunkCoordinates() {
    
	    return chunkCoordinates;
    }
    
    
}
