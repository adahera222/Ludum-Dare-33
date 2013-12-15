package com.indegame.ld28.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Button {

	public int x, y = 0;
	public int width, height = 0;
	public String buttonttext = "Button";
	public Color color;

	public Button(int x, int y, int width, int height, String buttontext, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.buttonttext = buttontext;
		this.color = color;
	}

	public boolean contains(Point p) {
		return new Rectangle(x, y, width, height).contains(p);
	}

	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
		g.setColor(new Color(0xFFFFFF));
		g.setFont(new Font("Arial", Font.PLAIN, width / 4));
		g.drawString(buttonttext, (x + width) - (width / 2) - (width / 4), (y + height) - (height / 4));
	}

}
