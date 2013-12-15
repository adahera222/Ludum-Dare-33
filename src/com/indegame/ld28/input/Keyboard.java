package com.indegame.ld28.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.indegame.ld28.entity.Control;

public class Keyboard extends KeyAdapter {

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_W) {
			Control.player.setUp(true);
		} else if (key == KeyEvent.VK_S) {
			Control.player.setDown(true);
		} else if (key == KeyEvent.VK_A) {
			Control.player.setLeft(true);
		} else if (key == KeyEvent.VK_D) {
			Control.player.setRight(true);
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_W) {
			Control.player.setUp(false);
		} else if (key == KeyEvent.VK_S) {
			Control.player.setDown(false);
		} else if (key == KeyEvent.VK_A) {
			Control.player.setLeft(false);
		} else if (key == KeyEvent.VK_D) {
			Control.player.setRight(false);
		}
	}

	public void keyTyped(KeyEvent e) {

	}

}
