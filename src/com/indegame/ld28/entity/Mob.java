package com.indegame.ld28.entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Mob extends Entity {
	protected boolean up, down, left, right = false;
	protected BufferedImage texture;

	public Mob(int x, int y, BufferedImage texture) {
		super(x, y);
		this.texture = texture;
	}

	public void update() {
		if (up) {
			y -= 5;
		} else if (down) {
			y += 5;
		} else if (left) {
			x -= 5;
		} else if (right) {
			x += 5;
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 64, 64);
	}

	public void render(Graphics g) {

	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

}
