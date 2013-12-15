package com.indegame.ld28.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Projectile extends Mob {

	public Projectile(int x, int y, BufferedImage texture) {
		super(x, y, texture);
		
	}

	public void update() {
		x += 2;
	}
	public void render(Graphics g) {
		g.drawImage(texture, x, y, null);
	}
}
