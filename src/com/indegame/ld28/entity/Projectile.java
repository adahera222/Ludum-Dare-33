package com.indegame.ld28.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.indegame.ld28.graphics.Texture;

public class Projectile extends Mob {

	public Projectile(int x, int y, Texture texture) {
		super(x, y, texture);
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 10, 3);
	}
	public void update() {
		x += 5;
	}
	public void render(Graphics g) {
		g.drawImage(texture.render(), x, y, null);
	}
}
