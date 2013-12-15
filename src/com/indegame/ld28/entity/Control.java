package com.indegame.ld28.entity;

import java.awt.Graphics;
import java.util.LinkedList;

import com.indegame.ld28.Game;
import com.indegame.ld28.graphics.Texture;
import com.indegame.ld28.sound.Sound;
import com.indegame.ld28.state.State;
import com.indegame.ld28.wave.Wave;

public class Control {
	public static Player player;

	private LinkedList<Mob> mobs = new LinkedList<Mob>();

	public Control() {
		player = new Player(10, 80, Texture.player);
	}

	public void addMob(Mob mob) {
		mobs.add(mob);
	}

	public void removeMob(Mob mob) {
		mobs.remove(mob);
	}

	public void update() {
		for(int i = 0; i < mobs.size(); i++) {
			Mob m = mobs.get(i);
			if(m instanceof REnemy || m instanceof FEnemy) {
				if(m.getX() <= 0) {
					removeMob(m);
					clearMobs();
					Game.state = State.END;
				}
			}
			if(m instanceof Projectile) {
				if(m.getX() >= Game.WIDTH) {
					removeMob(m);
				}
			}
		}
		for (int i = 0; i < mobs.size(); i++) {
			Mob m = mobs.get(i);

			m.update();
		}
		player.update();
	}

	public void render(Graphics g) {
		for (int i = 0; i < mobs.size(); i++) {
			Mob m = mobs.get(i);

			m.render(g);
		}
		player.render(g);
	}

	public void collision() {
		for (int i = 0; i < mobs.size(); i++) {
			Mob m = mobs.get(i);

			if (m instanceof Projectile) {
				
				for (int c = 0; c < mobs.size(); c++) {
					Mob a = mobs.get(c);
					
					if (!(a instanceof Projectile)) {
						
						if (m.getBounds().intersects(a.getBounds())) {
							System.out.println("Control.collision()");
							if(a instanceof FEnemy) {
								removeMob(a);
								mobs.remove(m);
								Sound.lose.play();
								clearMobs();
								Game.state = State.END;
							} 
							else if (a instanceof REnemy) {
								Sound.win.play();
								clearMobs();
								Wave.spawnWave(this);
							}
						}
					}
				}
			}
		}
	}
	public void clearMobs() {
		System.out.println("Before removal: "+mobs.size());
		for (int i = 0; i < mobs.size(); i++) {
			Mob m = mobs.get(i);
			mobs.remove(m);
		}
		System.out.println("After removal: " + mobs.size());
		for (int i = 0; i < mobs.size(); i++) {
			Mob m = mobs.get(i);
			mobs.remove(m);
		}
		System.out.println("After definite removal: " + mobs.size());
	}
}
