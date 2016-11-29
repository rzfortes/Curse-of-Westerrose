package packageRPG.state;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import packageRPG.Handler;

public class IntroState extends State {

	private BufferedImage logo;

	private int alpha;
	private int ticks;

	private final int FADE_IN = 60;
	private final int LENGTH = 60;
	private final int FADE_OUT = 60;

	public IntroState(Handler handler, GameStateManager gsm) {
		super(handler, gsm);
	}

	public void init() {
		ticks = 0;
		try {
			logo = ImageIO.read(getClass().getResourceAsStream("/textures/logo.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update() {
		handleInput();
		ticks++;
		if (ticks < FADE_IN) {
			alpha = (int) (255 - 255 * (1.0 * ticks / FADE_IN));
			if (alpha < 0)
				alpha = 0;
		}
		if (ticks > FADE_IN + LENGTH) {
			alpha = (int) (255 * (1.0 * ticks - FADE_IN - LENGTH) / FADE_OUT);
			if (alpha > 255)
				alpha = 255;
		}
		if (ticks > FADE_IN + LENGTH + FADE_OUT) {
			gsm.setState(GameStateManager.MENU);
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 640, 360);
		g.drawImage(logo, 0, 0, 640, 380, null);
		g.setColor(new Color(0, 0, 0, alpha));
		g.fillRect(0, 0, 640, 360);
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub

	}

}
