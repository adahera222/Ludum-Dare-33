package com.indegame.ld28.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class PlayButton extends Button {

	public PlayButton(int x, int y, int width, int height, String buttontext, Color color) {
		super(x, y, width, height, buttontext, color);
		
	}
	public boolean contains(Point p) {
		return new Rectangle(x, y, width, height).contains(p);
	}

	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
		g.setColor(new Color(0xFFFFFF));
		g.setFont(new Font("Arial", Font.PLAIN, width / 8));
		g.drawString(buttonttext, (x + width) - (width / 2 + 10) - (width / 4), (y + height) - (height / 4 + 2));
	}
}
