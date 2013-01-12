package net.minecraft.server.Plugins;

import net.minecraft.src.Block;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.World;

/**
 * Utilities for helping with {@link Block}s
 * @author gravypod
 *
 */
public class BlockUtil {
	
	/**
	 * Lock on this for /some/ thread safty...
	 */
	public static Object lock = new Object();
	
	/**
	 * Get a block object from an X, Y, and Z. 
	 * @param world - World to look in
	 * @param x - X Pos
	 * @param y - Y Pos
	 * @param z - Z Pos
	 * @return - returns {@link Block}
	 */
	public static Block getBlock(World world, int x, int y, int z) {
		synchronized(lock) {
			Block block = Block.blocksList[world.getBlockId(x, y, z)];    
			return block;
		}
	}
	
	/**
	 * Get a block from a chunk position
	 * @param world - World its in
	 * @param pos - {@link ChunkPosition} object
	 * @return {@link Block} object
	 */
	public static Block getBlock(World world, ChunkPosition pos) {
		return getBlock(world, pos.x, pos.y, pos.z);
	}
	
	/**
	 * Get a block to the side of another
	 * @param x - Original x
	 * @param y - Original y
	 * @param z - Original z
	 * @param side - Side this block is on
	 * @return - {@link Block}
	 */
	public static ChunkPosition getBlockOnSide(int x, int y, int z, int side) {
		
        if (side == 0)
        {
            --y;
        }

        if (side == 1)
        {
            ++y;
        }

        if (side == 2)
        {
            --z;
        }

        if (side == 3)
        {
            ++z;
        }

        if (side == 4)
        {
            --x;
        }

        if (side == 5)
        {
            ++x;
        }
        
        return new ChunkPosition(x, y, z);
		
	}
	
}
