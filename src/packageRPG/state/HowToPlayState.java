package packageRPG.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.gfx.Assets;
import packageRPG.ui.ClickListener;
import packageRPG.ui.UIImageButton;
import packageRPG.ui.UIManager;

public class HowToPlayState extends State {
	
	private UIManager uiManager;
	
	public HowToPlayState(Handler handler){
		super(handler);
		
		///State.setState(handler.getGame().howtoplayState);
		
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUiManager(uiManager);
		
		uiManager.addObject(new UIImageButton(500,300, 64, 32, Assets.button_start, new ClickListener(){

			@Override
			public void onClick() {
				handler.getMouseManager().setUiManager(null);
				State.setState(handler.getGame().menuState);
			}}));
		
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		uiManager.update();
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
		Color lightBlue = new Color(204, 229, 255);
		g.setColor(lightBlue);
		g.fillRect(0, 0, 640, 360);
		
		Font font = new Font("Vineta BT", Font.BOLD, 30);
		g.setFont(font);
		g.setColor(Color.black);
		g.drawString("WESTERROSE", 63, 40);
		g.drawString("Controls", 40, 60);
		
		/* A S W D KEYS for moving character
		 * 
		 * player's hungry bar decreases for a certain amount of time that he
		 * won't be able to eat. Once hunger bar reached 0, player's life will decrease
		 * by 25.
		 * Initially, player's life and hunger bar is 100. 
		 * Once, the player's life reached 0, game over.
		 * 
		 * press E to pick up item such as wood, and rock (from defeating monster)
		 * and print inventory items
		 * 
		 * either of the arrow keys can be used to defeat different monsters or entities,
		 * it is also used to eat fruits
		 * 
		 * For now, to enter the next world, kill the monster first to get a rock that will be the key
		 * 
		 * 
		 */		
		uiManager.render(g);
		
	}
}