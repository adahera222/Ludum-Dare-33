package com.indegame.ld28.entity;

public class Entity {
	protected int x, y;

	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void update() {
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
