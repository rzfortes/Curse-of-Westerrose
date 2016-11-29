package packageRPG;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;


import packageRPG.display.Display;
import packageRPG.gfx.Assets;
import packageRPG.gfx.GameCamera;
import packageRPG.input.KeyManager;
import packageRPG.input.MouseManager;
import packageRPG.state.GameStateManager;
import packageRPG.state.State;

public class Game implements Runnable {

	private Display display;
	private int width, height;
	public String title;

	private boolean running = false;
	private Thread thread;

	private BufferStrategy bs; // a hidden computer screen within your computer
	private Graphics g;

	// states
	public GameStateManager gsm;
	// public State gameState;
	// public State menuState;
	// public State howtoplayState;

	// input
	private KeyManager keyManager;
	private MouseManager mouseManager;

	// camera
	private GameCamera gameCamera;

	// handler
	private Handler handler;

	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;

		keyManager = new KeyManager();
		mouseManager = new MouseManager();

	}

	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();

		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		gsm = new GameStateManager(handler);

		// howtoplayState = new HowToPlayState(gsm);
		// gameState = new GameState(gsm);
		// menuState = new MenuState(gsm);
		// State.setState(state);
		// State.setState(menuState);

	}

	private void update() {
		gsm.update();
		keyManager.update();

		// if(State.getState()!= null)
		// State.getState().update();
		//
	}

	private void render() {

		bs = display.getCanvas().getBufferStrategy(); // para hindi magflicker
		if (bs == null) { // if there is no buffer canvas
			display.getCanvas().createBufferStrategy(3); // you only need 3
															// buffers
			return;
		}
		g = bs.getDrawGraphics(); // it allows us to draw
		// it is like a paint brush
		// clear screen
		g.clearRect(0, 0, width, height);

		gsm.render(g);
		/*
		 * //Draw here!
		 * 
		 * g.setColor(Color.red); g.fillRect(10, 50, 50, 70);
		 * g.setColor(Color.green); g.fillRect(0, 0, 10, 20);
		 */

		if (State.getState() != null)
			State.getState().render(g);

		// end drawing
		bs.show();
		g.dispose();

	}

	public void run() {

		init();

		int fps = 60; // fames per second, how many times we want update() to
						// run
		double timePerTick = 1000000000 / fps; // the maximum amount of times in
												// nano secs that we have to
												// execute the tick and time
												// method
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0; // time until we get to 1sec
		int ticks = 0;

		while (running) {
			now = System.nanoTime(); // current time of the computer
			delta += (now - lastTime) / timePerTick;
			timer += (now - lastTime);
			lastTime = now;

			if (delta >= 1) {
				update();
				render();
				ticks++;
				delta--;

			}
			if (timer >= 1000000000) { // if more than 1 sec
				// System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}

		stop();

	}

	public KeyManager getKeyManager() { // it will return the key manager so
										// that other classes can access it
		return keyManager;
	}

	public MouseManager getMouseManager() {
		return mouseManager;
	}

	public GameCamera getGameCamera() {
		return gameCamera;
	}

	public GameStateManager getGameStateManager() {
		return gsm;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this); // pass this class
		thread.start(); // will call the run method
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public void release(){
		display.getFrame().dispose();
		System.exit(0);
	
	}

}
