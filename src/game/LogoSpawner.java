package game;

import game.Game;
import gfx.Assets;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Discord on 11/11/2015.
 */
public class LogoSpawner {
    private final int LOGO_LIMIT = 5;
    private int currentLogos;
    private ListOfWordWithImages listOfWordWithImages;
    private ArrayList<WordWithImage> list;
    private ArrayList<Integer> listX;
    public static String currentInput;
    private WordWithImage temp = new WordWithImage(Assets.transparent, "1");
    private int num = 5;
    private int min = 1;
    private int max = 2;
    public int dead = 0;
    private ArrayList<Integer> listY;
    //private InputHandler inputHandler;
    //private WordWithImage wordWithImage;
    //public int x = 0;
    public BufferedImage image;
    Game game;
    public Rectangle enemy = new Rectangle(1200, 0, 80, 720);

    public LogoSpawner() {
        this.currentLogos = 0;
        this.listOfWordWithImages = new ListOfWordWithImages();
        //wordWithImage = new WordWithImage(Assets.adidas, "adidas");
        //wordWithImage = listOfWordWithImages.getRandomWord();
        list = new ArrayList<>();
        listX = new ArrayList<>();
        listY = new ArrayList<>();
        list.add(new WordWithImage(listOfWordWithImages.getRandomWord().getImage(), listOfWordWithImages.getRandomWord().getWord()));
        list.add(new WordWithImage(Assets.amazon, "amazon"));
        list.add(new WordWithImage(Assets.angrybirds, "angry birds"));
        list.add(new WordWithImage(Assets.apple, "apple"));
        list.add(new WordWithImage(Assets.audi, "audi"));

        listX.add(5);
        listX.add(5);
        listX.add(5);
        listX.add(5);
        listX.add(5);

        listY.add(0 + 0 * 90);
        listY.add(0 + 1 * 90);
        listY.add(0 + 2 * 90);
        listY.add(0 + 3 * 90);
        listY.add(0 + 4 * 90);

    }

    public void spawner(WordWithImage wordWithImage, int x){
        while(currentLogos <= LOGO_LIMIT){

//            if(!wordWithImage.getWord().equals(input)){
//                g.drawImage(wordWithImage.getImage(), x, 50, 128, 128, null);
//            }
        }
    }
    public void renderImage(Graphics g){
        g.setColor(Color.red);
        g.fillRect(enemy.x, enemy.y, enemy.width, enemy.height);
        for (int i = 0; i < num; i++) {
            if(listX.get(i) > enemy.x - list.get(i).getImage().getWidth() + 30) {
                System.out.print("You died");
                dead = 1;
            }

            if(!list.get(i).getWord().equals(currentInput)) {
                if(!list.get(i).getImage().equals(Assets.transparent)){
                    g.drawImage(list.get(i).getImage(), listX.get(i), listY.get(i), 75, 75, null);
                    listX.set(i, listX.get(i) + 3);
                }

            }
            else{
                list.set(i, temp);
                //num--;
            }


        }
    }

    public int randomVelocity(int min, int max){
        Random rand = new Random();
        int velocity = rand.nextInt((max - min) + 1) + min;

        return velocity;
    }
}
