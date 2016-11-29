package packageRPG.state;

import java.awt.Graphics;

import packageRPG.Handler;

//gamestate
public abstract class State {

	private static State currentState = null;

	public static void setState(State state) {
		currentState = state;

	}

	public static State getState() {
		return currentState;
	}

	// Class
	protected Handler handler;
	protected GameStateManager gsm;

	public State(Handler handler, GameStateManager gsm) {
		this.handler = handler;
		this.gsm = gsm;

	}

	public abstract void update();

	public abstract void init();

	public abstract void handleInput();

	public abstract void render(Graphics g);

}
