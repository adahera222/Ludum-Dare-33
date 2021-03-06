package com.indegame.ld28.entity;

import java.awt.Graphics;

import com.indegame.ld28.graphics.Texture;

public class Player extends Mob {

	public Player(int x, int y, Texture texture) {
		super(x, y, texture);
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

	public void render(Graphics g) {
		g.drawImage(texture.render(), x, y, null);
	}

}
