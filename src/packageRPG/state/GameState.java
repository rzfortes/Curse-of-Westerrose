package packageRPG.state;

import java.awt.Graphics;
import java.io.InputStream;
import packageRPG.sfx.Sound;

import packageRPG.Handler;
import packageRPG.maps.Maps;

public class GameState extends State {

	private Maps map;

	public GameState(Handler handler, GameStateManager gsm) {
		super(handler, gsm);

		InputStream in = getClass().getResourceAsStream("/maps/world2.txt");
		// BufferedReader reader = new BufferedReader(new
		// InputStreamReader(in));

		// InputStream input =
		// getClass().getResourceAsStream("/maps/world2.txt");
		map = new Maps(handler, in);
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

	@Override
	public void init() {
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub

	}

}