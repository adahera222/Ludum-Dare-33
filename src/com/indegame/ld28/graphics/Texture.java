package com.indegame.ld28.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Texture {
	public BufferedImage texture;
	public Texture(String path) {
		try {
			texture = ImageIO.read(Texture.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Texture player = new Texture("/texture/playerSprite.png");
	public static Texture enemy = new Texture("/texture/enemySprite.png");
	public static Texture bullet = new Texture("/texture/bulletSprite.png");
	public static Texture mainmenubanner = new Texture("/texture/menubanner.png");
	public static Texture background = new Texture("/texture/background.png");


	public BufferedImage render() {
		return texture;
	}
}
