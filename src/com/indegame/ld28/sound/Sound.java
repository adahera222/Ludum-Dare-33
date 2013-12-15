package com.indegame.ld28.sound;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {
	private AudioClip sound;

	public Sound(String path) {
		sound = Applet.newAudioClip(Sound.class.getResource(path));
	}

	public static final Sound shoot = new Sound("/sound/shoot.wav");
	public static final Sound lose = new Sound("/sound/enemydead.wav");
	public static final Sound win = new Sound("/sound/win.wav");
	public static final Sound mainmusic = new Sound("/sound/mixdown.wav");
	public static final Sound select = new Sound("/sound/select.wav");



	public void play() {
		sound.play();
	}
}
