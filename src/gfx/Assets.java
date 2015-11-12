package gfx;

import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.HashMap;

public class Assets {

    private static final int width = 128, height = 128;

    public static BufferedImage player1, player2, adidas, angrybirds, apple, audi, facebook, amazon, google, intel, msn, starwars, sega, nike, wikipedia,samsung, microsoft, transparent;
    //Loads every resource needed for the game
    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/java.png"));
        adidas = ImageLoader.loadImage("/textures/adidas.png");
        angrybirds = ImageLoader.loadImage("/textures/angrybirds.png");
        apple = ImageLoader.loadImage("/textures/apple.png");
        audi = ImageLoader.loadImage("/textures/audi.png");
        amazon = ImageLoader.loadImage("/textures/amazon.png");

        facebook = ImageLoader.loadImage("/textures/facebook.png");
        google = ImageLoader.loadImage("/textures/google.png");
        intel = ImageLoader.loadImage("/textures/intel.png");
        msn = ImageLoader.loadImage("/textures/msn.png");
        starwars = ImageLoader.loadImage("/textures/starwars.png");

        sega = ImageLoader.loadImage("/textures/sega.png");
        nike = ImageLoader.loadImage("/textures/nike.png");
        wikipedia = ImageLoader.loadImage("/textures/wikipedia.png");
        samsung = ImageLoader.loadImage("/textures/samsung.png");
        microsoft = ImageLoader.loadImage("/textures/microsoft.png");

        transparent = ImageLoader.loadImage("/textures/transparent.png");

        player1 = sheet.crop(0, 0, width, height);
        player2 = sheet.crop(0, 0, width, height);
    }
}
