package chrislo27.rhre.desktop;

import chrislo27.rhre.Main;
import chrislo27.rhre.lazysound.LazySound;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.graphics.Color;
import ionium.desktop.ArgumentInferredLwjglAppConfig;
import ionium.desktop.GameLwjglApp;
import ionium.registry.GlobalVariables;
import ionium.util.Logger;

import java.util.Arrays;

public class DesktopLauncher {
	private static Logger logger;

	public static void main(String[] args) {
		System.setProperty("org.lwjgl.opengl.Display.allowSoftwareOpenGL", "true");

		logger = new Logger("", com.badlogic.gdx.utils.Logger.DEBUG);
		final Main main = new Main(logger);

		ArgumentInferredLwjglAppConfig config = new ArgumentInferredLwjglAppConfig(args);
		config.title = "Rhythm Heaven Remix Editor";
		config.width = GlobalVariables.defaultWidth;
		config.height = GlobalVariables.defaultHeight;
		config.fullscreen = false;
		config.foregroundFPS = GlobalVariables.maxFps;
		config.backgroundFPS = GlobalVariables.maxFps;
		config.resizable = true;
		config.vSyncEnabled = true;
		config.samples = 0;
		config.initialBackgroundColor = Color.BLACK;
		config.allowSoftwareMode = true;

		config.inferFromArguments();

		config.addIcon("images/icon/icon128.png", Files.FileType.Internal);
		config.addIcon("images/icon/icon64.png", Files.FileType.Internal);
		config.addIcon("images/icon/icon32.png", Files.FileType.Internal);
		config.addIcon("images/icon/icon16.png", Files.FileType.Internal);

		LazySound.Companion.setForceLoadNow(Arrays.stream(args).anyMatch(s -> s.equalsIgnoreCase("--force-load-lazy-sounds")));
		new GameLwjglApp(main, config, logger);
	}
}
