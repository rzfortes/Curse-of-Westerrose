package packageRPG.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JOptionPane;

import packageRPG.Handler;
import packageRPG.gfx.Assets;
import packageRPG.ui.ClickListener;
import packageRPG.ui.UIImageButton;
import packageRPG.ui.UIManager;

public class MenuState extends State {

	private UIManager uiManager;
	
	public MenuState(Handler handler){
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUiManager(uiManager);
		
		uiManager.addObject(new UIImageButton(175, 150, 128, 64, Assets.button_start, new ClickListener(){

			@Override
			public void onClick() {
				handler.getMouseManager().setUiManager(null);
				State.setState(handler.getGame().gameState);
			}}));
		//how to play
		uiManager.addObject(new UIImageButton(320, 150, 128, 64, Assets.button_rules, new ClickListener(){

			@Override
			public void onClick() {
				String howToPlay = "Use A-S-W-D KEYS to move the character \n\nPlayer's hungry bar decreases "
						+ "for a certain amount of time that he won't be able to eat. \n\nOnce hunger bar "
						+ "reached 0, player's life will decrease by 25. \nInitially, player's life and hunger bar is 100."
						+ "\nOnce, the player's life reached 0, game over."
						+ "\n\nPress E to print inventory items (if you already have one). "
						+ "To pick the items, simply walk over it and it will be saved in the inventory."
						+ "\n\nEither of the arrow keys can be used to defeat different monsters or entities, such as trees, etc."
						+ " it is also used to eat fruits"
						+ "\n\nFor now, to enter the next world, kill the monster first to get the rock that will be the key";

				JOptionPane.showMessageDialog(null, howToPlay, "How To Play?", JOptionPane.PLAIN_MESSAGE);
				// not yet ready
			}}));

		/*
		 * 
		 * A S W D KEYS for moving character
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
		 */
		
		
		
		//quit
		uiManager.addObject(new UIImageButton(250, 230, 128, 64, Assets.button_exit, new ClickListener(){

			@Override
			public void onClick() {
				System.exit(0);
			}}));
	}
	
	@Override
	public void update(){
		uiManager.update();	
	}

	@Override
	public void render(Graphics g) {
		Color lightBlue = new Color(204, 229, 255);
		g.setColor(lightBlue);
		g.fillRect(0, 0, 640, 360);
		
		Font font = new Font("Vineta BT", Font.BOLD, 45);
		g.setFont(font);
		g.setColor(Color.black);
		g.drawString("WESTERROSE", 63, 110);
		
		uiManager.render(g);
	}
	
	
}
