package gfx;

import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.HashMap;

public class Assets {

    private static final int width = 128, height = 128;

    public static BufferedImage player1, player2, adidas, angrybirds, apple, audi, facebook, amazon, transparent;
    //Loads every resource needed for the game
    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/java.png"));
        adidas = ImageLoader.loadImage("/textures/adidas.png");
        angrybirds = ImageLoader.loadImage("/textures/angrybirds.png");
        apple = ImageLoader.loadImage("/textures/apple.png");
        audi = ImageLoader.loadImage("/textures/audi.png");
        facebook = ImageLoader.loadImage("/textures/facebook.png");
        amazon = ImageLoader.loadImage("/textures/amazon.png");
        transparent = ImageLoader.loadImage("/textures/transparent.png");

        player1 = sheet.crop(0, 0, width, height);
        player2 = sheet.crop(0, 0, width, height);
    }
}
