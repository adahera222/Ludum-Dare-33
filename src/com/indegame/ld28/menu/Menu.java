package com.indegame.ld28.menu;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import com.indegame.ld28.graphics.Texture;

public class Menu {
	public Texture banner;
	public LinkedList<Button> buttons = new LinkedList<Button>();

	public Menu(Texture banner) {
		this.banner = banner;
		addComponents();
	}

	public void addComponents() {
		buttons.add(new Button(150, 300, 400, 100, "Play", new Color(0x000000)));
	}

	public void update() {

	}

	public void render(Graphics g) {
		for (Button b : buttons) {
			b.render(g);
		}
		g.drawImage(banner.render(), 100, 50, null);
	}
}
