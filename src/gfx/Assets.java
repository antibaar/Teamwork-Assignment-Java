package gfx;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class Assets {

    private static final int width = 128, height = 128;

    public static BufferedImage player1, player2;
    //Loads every resource needed for the game
    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/java.png"));
        java = ImageLoader.loadImage("/textures/java.png");

        player1 = sheet.crop(0, 0, width, height);
        player2 = sheet.crop(0, 0, width, height);
    }
    public static BufferedImage java;
}
