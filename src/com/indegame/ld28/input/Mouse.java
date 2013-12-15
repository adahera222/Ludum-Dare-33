package com.indegame.ld28.input;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import com.indegame.ld28.Game;
import com.indegame.ld28.entity.Control;
import com.indegame.ld28.entity.Projectile;
import com.indegame.ld28.sound.Sound;
import com.indegame.ld28.state.State;
import com.indegame.ld28.wave.Wave;

public class Mouse implements MouseListener {
	public static boolean fired = false;
	static boolean fireEnabled = false;

	public void mouseClicked(MouseEvent e) {
		if (Game.state == State.MENU) {
			Point m = new Point(e.getX(), e.getY());
			if (Game.menu.buttons.get(0).contains(m)) {
				Sound.select.play();
				Game.state = State.GAME;
				Wave.spawnWave(Game.control, Game.control.tex);
			}
		}
		if (Game.state == State.GAME) {
			System.out.println("Mouse.mouseClicked() -- State.GAME");
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				public void run() {
					System.out.println("Mouse.mouseClicked() -- TimerTask run");
					fireEnabled = true;
				}
			}, 1000L);
			if (!fireEnabled) return;
			if (fired) return;
			Sound.shoot.play();
			int x = Control.player.getX();
			int y = Control.player.getY();
			BufferedImage texture = Game.control.tex.bullet;
			Game.control.addMob(new Projectile(x, y, texture));
			fired = true;
		}
		if(Game.state == State.END) {
			Point m = new Point(e.getX(), e.getY());
			if(Game.pa.contains(m)){
				Sound.select.play();
				Game.restartGame();
			}
			
		}
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}
	public static void reset() {
		fired = false;
		fireEnabled=false;
	}
}
