package com.indegame.ld28.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Textures {
	public BufferedImage player;
	public BufferedImage enemy;
	public BufferedImage background;
	public BufferedImage bullet;
	public BufferedImage mainmenubanner;

	public Textures() {
		player = getImage("/textures/playerSprite.png");
		enemy = getImage("/textures/enemySprite.png");
		background = getImage("/textures/background.png");
		bullet = getImage("/textures/bulletSprite.png");
		mainmenubanner = getImage("/textures/menubanner.png");
	}

	public BufferedImage getImage(String path) {
		try {
			return ImageIO.read(getClass().getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
