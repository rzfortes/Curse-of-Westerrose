package packageRPG.state;


import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.gfx.Assets;
import packageRPG.ui.ClickListener;
import packageRPG.ui.UIImageButton;
import packageRPG.ui.UIManager;

public class MenuState extends State {

	private UIManager uiManager;

	public MenuState(Handler handler, GameStateManager gsm) {
		super(handler, gsm);

		uiManager = new UIManager(handler);
		handler.getMouseManager().setUiManager(uiManager);

		uiManager.addObject(new UIImageButton(250, 120, 64, 64, Assets.controllers, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUiManager(null);
				handler.getGame().getGameStateManager().setState(GameStateManager.PLAY);
			}
		}));
		// how to play
		uiManager.addObject(new UIImageButton(250, 180, 64, 64, Assets.htp, new ClickListener() {

			@Override
			public void onClick() {
				handler.getGame().getGameStateManager().setState(GameStateManager.HTP);
			}
		}));
		
		//credits
		uiManager.addObject(new UIImageButton(258, 245, 48, 48, Assets.credits, new ClickListener() {

			@Override
			public void onClick() {
				handler.getGame().getGameStateManager().setState(GameStateManager.CREDITS);
			}
		}));

		
		// quit
		uiManager.addObject(new UIImageButton(258, 300, 48, 48, Assets.exit, new ClickListener() {

			@Override
			public void onClick() {
				System.exit(0);
			}
		}));
	}

	@Override
	public void update() {
		uiManager.update();
		// handleInput();
	}

	@Override
	public void render(Graphics g) {

		g.drawImage(Assets.menu1, 0, 0, null);
		
		
		uiManager.render(g);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub

	}

}
