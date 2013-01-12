package net.minecraft.server.Plugins.Events.World;

import java.util.HashSet;

import net.minecraft.server.Plugins.Events.Event;
import net.minecraft.src.Block;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.Explosion;
import net.minecraft.src.World;

/**
 * ExplosionEvent is thrown when an {@link Explosion} is created
 * TODO: Add all other explosion and find a way to make a {@link Block}-map instead of {@link ChunkPosition}
 * @author gravypod
 *
 */
public class ExplosionEvent extends Event {
	
	private final Explosion explosion;
	
	private final HashSet<ChunkPosition> chunkPossition;
	
	private final World world;
	
	/**
	 * Create a {@link ExplosionEvent}
	 * @param explosion - {@link Explosion} that will happen
	 * @param world - {@link World} this is happening in
	 * @param chunkPossition
	 */
	public ExplosionEvent(Explosion explosion, World world, HashSet<ChunkPosition> chunkPossition) {
	
		this.explosion = explosion;
		this.chunkPossition = chunkPossition;
		this.world = world;
		
		for (ChunkPosition chunkPositions : chunkPossition) {
			
			if (!world.blockExists(chunkPositions.x, chunkPositions.y, chunkPositions.z)) {
				chunkPossition.remove(chunkPositions);
			}
			
		}
		
	}
	
	/**
	 * Get the world this is happening in
	 * @return - {@link World} instance
	 */
	public World getWorld() {
	
		return world;
	}
	
	/**
	 * {@link ChunkPosition}s that where effected
	 * @return - {@link HashSet} of all the {@link ChunkPosition}s effected
	 */
	public HashSet<ChunkPosition> getChunkPossition() {
	
		return chunkPossition;
	}
	
	/**
	 * Get the {@link Explosion}
	 * @return - {@link Explosion} instance
	 */
	public Explosion getExplosion() {
	
		return explosion;
	}
	
}
