package packageRPG;

import packageRPG.gfx.GameCamera;
import packageRPG.input.KeyManager;
import packageRPG.maps.Maps;

public class Handler {
	
	private Game game;
	private Maps map;
	
	public Handler(Game game){
		this.game = game;
	}
	
	public GameCamera getGameCamera(){
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}
	

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Maps getMap() {
		return map;
	}

	public void setMap(Maps map) {
		this.map = map;
	}
	
}
