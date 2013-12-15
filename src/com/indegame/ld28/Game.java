package com.indegame.ld28;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.indegame.ld28.entity.Control;
import com.indegame.ld28.input.Keyboard;
import com.indegame.ld28.input.Mouse;
import com.indegame.ld28.menu.Button;
import com.indegame.ld28.menu.Menu;
import com.indegame.ld28.menu.PlayButton;
import com.indegame.ld28.sound.Sound;
import com.indegame.ld28.state.State;
import com.indegame.ld28.wave.Wave;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	// Integer
	public static final int WIDTH = 700;
	public static final int HEIGHT = WIDTH / 4 * 3;
	public static int SECONDS = 0;
	// String
	public static final String TITLE = "Ludum Dare 28";
	// Boolean
	public boolean running = false;
	// Main Objects
	private Thread thread;
	public JFrame frame;
	public BufferedImage buffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	// Game Objects
	public static Control control;
	public static State state = State.MENU;
	public static Menu menu;

	public Game() {
		frame = new JFrame(TITLE);
		control = new Control();
		menu = new Menu(control.tex.mainmenubanner);

		Keyboard key = new Keyboard();
		addKeyListener(key);
		addMouseListener(new Mouse());

		Dimension size = new Dimension(WIDTH, HEIGHT);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
	}

	public synchronized void start() {
		if (running) return;

		thread = new Thread(this, "Display");
		thread.start();

		running = true;
	}

	public synchronized void stop() {
		if (!running) return;

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		running = false;
		System.exit(0);
	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double delta = 0;
		double ns = 1000000000.0 / 60;
		int frames = 0;
		int updates = 0;
		long timer = System.currentTimeMillis();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				updates++;
				update();
				delta--;

			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer >= 1000) {
				timer += 1000;
				System.out.println(frames + " fps, " + updates + " updates");
				frames = 0;
				updates = 0;
				SECONDS++;
			}
		}
	}

	boolean playmusic = true;

	public void update() {
		if (state == State.MENU) {
			if (playmusic) {
				Sound.mainmusic.play();
				playmusic = false;
			}
		}
		if (state == State.GAME) {
			control.update();
			control.collision();

		} else if (state == State.END) {

		}

	}

	public static Button pa = new PlayButton(150, 325, 400, 100, "Play Again", new Color(0x000000));

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		// /////////////////////////////////

		g.drawImage(buffer, 0, 0, getWidth(), getHeight(), null);
		g.drawImage(control.tex.background, 0, 0, null);
		if (state == State.MENU) {
			menu.render(g);
		} else if (state == State.GAME) {
			control.render(g);
		} else if (state == State.END) {
			g.setFont(new Font("Arial", Font.BOLD, 100));
			g.setColor(new Color(0xF78F28));
			g.drawString("YOU LOST", 100, 200);
			g.setFont(new Font("Arial", Font.BOLD, 50));
			g.setColor(new Color(0xF78F28));
			g.drawString("Your wave was: " + Wave.WAVE_COUNT, 135, 300);
			pa.render(g);
		}

		// /////////////////////////////////
		g.dispose();
		bs.show();
	}

	public static void restartGame() {
		Wave.WAVE_COUNT = 0;
		control.clearMobs();
		state = State.MENU;
		Mouse.reset();
	}

	public static void main(String[] args) {
		Game game = new Game();

		game.frame.add(game);
		game.frame.pack();

		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);

		game.frame.setResizable(false);
		game.frame.setVisible(true);

		game.start();
	}
}
