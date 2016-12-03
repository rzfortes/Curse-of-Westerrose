package packageRPG.tiles;

import packageRPG.gfx.Assets;

public class DesertBorderTile extends Tile {

	public DesertBorderTile(int id) {
		super(Assets.desertBorder, id);

	}

	@Override
	public boolean isSolid() {
		return true;
	}

}
