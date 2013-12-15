package com.indegame.ld28.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class FEnemy extends Mob {

	public FEnemy(int x, int y, BufferedImage texture) {
		super(x, y, texture);
	}

	public void update() {
		x -= 1;
	}

	public void render(Graphics g) {
		g.drawImage(texture, x, y, null);
	}
}