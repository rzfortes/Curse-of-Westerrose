package packageRPG.state;

import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.gfx.Assets;
import packageRPG.ui.ClickListener;
import packageRPG.ui.UIImageButton;
import packageRPG.ui.UIManager;

public class GameOverState extends State {
	private UIManager uiManager;

	public GameOverState(Handler handler, GameStateManager gsm) {
		super(handler, gsm);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUiManager(uiManager);
		
		
		uiManager.addObject(new UIImageButton(300, 230, 48, 48, Assets.exit, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUiManager(null);
				handler.getGame().release();
				//handler.getGame().getGameStateManager().setState(GameStateManager.INTRO);
				
			}
		}));
		
	}

	@Override
	public void update() {
		uiManager.update();

		
	}

	@Override
	public void init() {
		
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.gameover, 0, 0,  null);
		uiManager.render(g);
		


	}

}
