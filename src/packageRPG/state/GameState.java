package packageRPG.state;

import java.awt.Graphics;

import packageRPG.Game;
import packageRPG.entities.creatures.Player;
import packageRPG.gfx.Assets;
import packageRPG.maps.Maps;
import packageRPG.tiles.Tile;

public class GameState extends State {

	private Player player;
	private Maps map;
	
	public GameState(Game game){
		super(game);
		player = new Player(game,100,100);
		map = new Maps(game, "resources/maps/world1.txt");
		
		//game.getGameCamera().move(0, 0);
	}
	
	@Override
	public void update() {
		map.update();
		player.update();
	
		
	}

	@Override
	public void render(Graphics g) {
		//g.drawImage(Assets.dirt, 0, 0, null);
		map.render(g);
		player.render(g);
		//Tile.tiles[2].render(g, 0 , 0);
		
	}

	
}
