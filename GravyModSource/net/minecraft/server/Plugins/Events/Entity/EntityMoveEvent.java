package net.minecraft.server.Plugins.Events.Entity;

import net.minecraft.server.Plugins.Events.Event;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;

/**
 * Not yet implemented, Fired when an entity moves
 * 
 * @author gravypod
 * 
 */
public class EntityMoveEvent extends Event {
	
	private Block from;
	
	private Block to;
	
	private Entity entity;
	
	/**
	 * Create an {@link EntityMoveEvent}
	 * @param entity - Entity that moved
	 * @param from - {@link Block} they where at
	 * @param to - {@link Block} they are going to
	 */
	public EntityMoveEvent(Entity entity, Block from, Block to) { // TODO: Do not use blocks, use ChunkPositions
	
		this.entity = entity;
		this.from = from;
		this.to = to;
	}
	
	public Block getFrom() {
	
		return from;
	}
	
	public Entity getEntity() {
	
		return entity;
	}
	
	public Block getTo() {
	
		return to;
	}
	
}
