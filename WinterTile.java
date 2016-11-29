package packageRPG.tiles;

import packageRPG.gfx.Assets;

public class WinterTile extends Tile {

	public WinterTile(int id) {
		super(Assets.winterTile, id);

	}

	@Override
	public boolean isSolid() {
		return false;
	}

}
