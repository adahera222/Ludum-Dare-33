package com.indegame.ld28.wave;

import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import com.indegame.ld28.Game;
import com.indegame.ld28.entity.Control;
import com.indegame.ld28.entity.FEnemy;
import com.indegame.ld28.entity.REnemy;
import com.indegame.ld28.graphics.Textures;
import com.indegame.ld28.input.Mouse;

public class Wave {
	public static int WAVE_COUNT = 0;
	public static int REAL_ENEMY_COUNT = 1;
	public static int FAKE_ENEMY_COUNT = 2;

	public static void spawnWave(final Control c, final Textures tex) {
		System.out.println("Wave.spawnWave()");
		Timer time = new Timer();
		time.schedule(new TimerTask() {
			public void run() {
				System.out.println("TimerTask run");
				Mouse.fired = false;
				WAVE_COUNT++;
				Random rand = new Random();
				int rEnemyPos = rand.nextInt(3) + 1;
				BufferedImage enemy = tex.enemy;
				System.out.println("Random number is: " + rEnemyPos);
				if (rEnemyPos == 1) {
					c.addMob(new REnemy(Game.WIDTH, Game.HEIGHT / 6, enemy));
					c.addMob(new FEnemy(Game.WIDTH, (Game.HEIGHT / 6) + (Game.HEIGHT / 6), enemy));
					c.addMob(new FEnemy(Game.WIDTH, (Game.HEIGHT / 6) + (Game.HEIGHT / 6 * 2), enemy));
				} else if (rEnemyPos == 2) {
					c.addMob(new FEnemy(Game.WIDTH, Game.HEIGHT / 6, enemy));
					c.addMob(new REnemy(Game.WIDTH, (Game.HEIGHT / 6) + (Game.HEIGHT / 6), enemy));
					c.addMob(new FEnemy(Game.WIDTH, (Game.HEIGHT / 6) + (Game.HEIGHT / 6 * 2), enemy));
				} else if (rEnemyPos == 3) {
					c.addMob(new FEnemy(Game.WIDTH, Game.HEIGHT / 6, enemy));
					c.addMob(new FEnemy(Game.WIDTH, (Game.HEIGHT / 6) + (Game.HEIGHT / 6), enemy));
					c.addMob(new REnemy(Game.WIDTH, (Game.HEIGHT / 6) + (Game.HEIGHT / 6 * 2), enemy));
				}
			}
		}, 5000L);
		
	}
}
