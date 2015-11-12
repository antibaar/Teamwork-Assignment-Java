package gfx;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage  adidas, angrybirds, apple, audi, facebook, amazon, google, intel, msn, starwars, sega, nike, wikipedia,samsung, microsoft, transparent;

    public static void init() {
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

    }
}
