package packageRPG.state;

import java.awt.Graphics;

import packageRPG.Handler;
import packageRPG.gfx.Assets;
import packageRPG.ui.ClickListener;
import packageRPG.ui.UIImageButton;
import packageRPG.ui.UIManager;

public class CreditsState extends State{
	private UIManager uiManager;
	
	public CreditsState(Handler handler, GameStateManager gsm) {
		super(handler, gsm);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUiManager(uiManager);
		uiManager.addObject(new UIImageButton(560, 20, 64, 64, Assets.mainmenu, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUiManager(null);
				handler.getGame().getGameStateManager().setState(GameStateManager.MENU);
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
		
		g.drawImage(Assets.creditsbg, 0, 0,  null);
		
		
		
		uiManager.render(g);

	}

}
