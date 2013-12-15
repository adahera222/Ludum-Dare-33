package com.indegame.ld28.entity;

import java.awt.Graphics;

import com.indegame.ld28.graphics.Texture;

public class FEnemy extends Mob {

	public FEnemy(int x, int y, Texture texture) {
		super(x, y, texture);
	}

	public void update() {
		x -= 1;
	}

	public void render(Graphics g) {
		g.drawImage(texture.render(), x, y, null);
	}
}
