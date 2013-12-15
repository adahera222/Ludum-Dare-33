package com.indegame.ld28.util;

import com.indegame.ld28.Game;

public class Timer {
	private int nowseconds = 0;
	private boolean finished = false;
	public void startTimer(int seconds) {
		int nowseconds = Game.SECONDS;
		int objective = Game.SECONDS + seconds;
		while(nowseconds < objective) {
			this.nowseconds = nowseconds;
		}
		finished = true;
	}
	public int getSecondsPassed() {
		return nowseconds;
	}
	public boolean isFinished() {
		return finished;
	}
}
