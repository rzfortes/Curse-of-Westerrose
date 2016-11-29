package packageRPG.state;

import java.awt.Graphics;

import javax.swing.JOptionPane;

import packageRPG.Handler;
import packageRPG.sfx.Sound;

public class GameStateManager {

	private State[] gameStates;
	private int currentState;
	private int previousState;
	private Handler handler;

	public static final int NUM_STATES = 8;
	public static final int INTRO = 0;
	public static final int MENU = 1;
	public static final int PLAY = 2;
	public static final int HTP = 3;
	public static final int CONTROLS = 4;
	public static final int CREDITS = 5;
	public static final int GAMEOVER = 6;
	

	public GameStateManager(Handler handler) {
		// music
		this.handler = handler;
		gameStates = new State[NUM_STATES];
		setState(INTRO);
	}

	public void setState(int i) {
		previousState = currentState;
		unloadState(previousState);
		currentState = i;
		if (i == INTRO) {
			gameStates[i] = new IntroState(handler, this);
			gameStates[i].init();
		} else if (i == MENU) {
			gameStates[i] = new MenuState(handler, this);
			// gameStates[i].init();
		} else if (i == PLAY) {
			gameStates[i] = new GameState(handler, this);
			Sound.BACK.loop();

			// gameStates[i].init();
		} else if (i == HTP) {
			gameStates[i] = new HowToPlayState(handler, this);
		} else if (i == CONTROLS) {
			gameStates[i] = new ControlsState(handler, this);
		}
		else if (i == CREDITS) {
			gameStates[i] = new CreditsState(handler, this);
		}

		else if (i == GAMEOVER) {
			 gameStates[i] = new GameOverState(handler,this);
			// gameStates[i].init();
			Sound.BACK.stop();
			Sound.GAMEOVER.play();
			
		}
		
		
	}

	public void unloadState(int i) {
		gameStates[i] = null;
	}

	public void update() {
		if (gameStates[currentState] != null) {
			gameStates[currentState].update();
		}
	}

	public void render(Graphics g) {
		if (gameStates[currentState] != null) {
			gameStates[currentState].render(g);
		}
	}

}
