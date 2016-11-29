package packageRPG.sfx;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {
	public static final AudioClip BACK = Applet
			.newAudioClip(Sound.class.getResource("/Sound/Escape from the city.wav"));

	public static final AudioClip GAMEOVER = Applet.newAudioClip(Sound.class.getResource("/Sound/GameOver.wav"));
}
