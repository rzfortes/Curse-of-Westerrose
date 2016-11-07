package packageRPG.state;

import java.awt.Graphics;

import packageRPG.Game;
import packageRPG.Handler;
import packageRPG.gfx.Assets;

public class MenuState extends State {

	public MenuState(Handler handler){
		super(handler);
	}
	
	@Override
	public void update(){
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.menu, 0, 0, null);
		
	}
	
	
}
