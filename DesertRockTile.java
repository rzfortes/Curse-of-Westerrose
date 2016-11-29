package packageRPG.tiles;

import java.awt.image.BufferedImage;

import packageRPG.gfx.Assets;

public class DesertRockTile extends Tile {

	public DesertRockTile(int id) {
		super(Assets.desertRock, id);

	}

	@Override
	public boolean isSolid() {
		return true;
	}

}
