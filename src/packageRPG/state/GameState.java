package packageRPG.state;

import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.maps.Maps;

public class GameState extends State {

	private Maps map;
	
	public GameState(Handler handler){
		super(handler);
		
		map = new Maps(handler, "resources/maps/world2.txt");
		handler.setMap(map); 
	}
	
	@Override
	public void update() {
		map.update();
	}

	@Override
	public void render(Graphics g) {
		map.render(g);
		
	}

	
}
