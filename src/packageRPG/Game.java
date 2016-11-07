package packageRPG;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


import packageRPG.display.Display;
import packageRPG.gfx.Assets;
import packageRPG.gfx.GameCamera;
import packageRPG.gfx.ImageLoader;
import packageRPG.gfx.SpriteSheet;
import packageRPG.input.KeyManager;
import packageRPG.state.GameState;
import packageRPG.state.MenuState;
import packageRPG.state.State;


public class Game implements Runnable{
	
	private Display display;
	private int width, height;
	public String title;

	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs; // a hidden computer screen within your computer
	private Graphics g;
	
	//states
	private State gameState;
	private State menuState;
	
//input
	private KeyManager keyManager;
	
	//camera
	private GameCamera gameCamera;
	
	//handler
	private Handler handler;
	
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		
		keyManager = new KeyManager();
		
		
	}
	
	private void init(){
		display = new Display(title, width,height);
		display.getFrame().addKeyListener(keyManager);;
		Assets.init();
		
		gameCamera = new GameCamera(this,0,0);
		handler = new Handler(this);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		//State.setState(menuState);
		State.setState(gameState);
		

	}
	
	
	private void update(){
		keyManager.update(); 
		
		if(State.getState()!= null)
			State.getState().update();
				
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy(); //para hindi magflicker
		if(bs == null){ //if there is no buffer canvas
			display.getCanvas().createBufferStrategy(3); //you only need 3 buffers
			return;
		}
		g = bs.getDrawGraphics(); //it allows us to draw 
		//it is like a paint brush
		//clear screen
		g.clearRect(0, 0, width, height);
		
				
		/*//Draw here!
		
		g.setColor(Color.red);
		g.fillRect(10, 50, 50, 70);
		g.setColor(Color.green);
		g.fillRect(0, 0, 10, 20);
		*/
		
		if(State.getState()!= null)
			State.getState().render(g);
		
	
		
		
		
		//end drawing
		bs.show();
		g.dispose();
		
		
		
		
		
		
	}
	public void run(){
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000/fps; //the maximum amount of times in nano secs that we have to execute the tick and time method 
		double delta =0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0; //time until we get to 1sec
		int ticks = 0;
		
		while(running){
			now = System.nanoTime(); //current time of the computer
			delta += (now- lastTime)/ timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >=1 ){
				update();
				render();
				ticks++;
				delta--;
				
			}
			if(timer >= 1000000000){ //if more than 1 sec
				System.out.println("Ticks and Frames: " + ticks);
				ticks =0;
				timer =0;
			}
		}
		
		stop();
		
	}
	
	public KeyManager getKeyManager(){  //it will return the key manager so that other classes can access it
		return keyManager;
	}
	
	public GameCamera getGameCamera(){
		return gameCamera;
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
	
	
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this); //pass this class
		thread.start(); //will call the run method
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
