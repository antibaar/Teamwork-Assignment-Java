package game;

import gfx.Assets;


import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class LogoSpawner {
    private ListOfWordWithImages listOfWordWithImages;
    private ArrayList<WordWithImage> list;
    private ArrayList<Integer> listX;
    public static String currentInput;
    private WordWithImage temp = new WordWithImage(Assets.transparent, "1");
    private int num = 5;
    private int min = 1;
    private int max = 3;
    public int dead = 0;
    public int lives = 3;
    public int score = 0;
    public int count = 0;
    public boolean check = false;
    private ArrayList<Integer> listY;


    public Rectangle enemy = new Rectangle(1200, 0, 80, 720);

    public LogoSpawner(ListOfWordWithImages List) {
        this.listOfWordWithImages = List;

        list = new ArrayList<>();
        listX = new ArrayList<>();
        listY = new ArrayList<>();


        for(int i = 0; i < 15; i++){
            list.add(new WordWithImage(listOfWordWithImages.getRandomWord().getImage(), listOfWordWithImages.word));
            listX.add(5);
        }

        for(int i = 0; i < 3; i++){
            for(int y = 0; y < 5; y++){
                listY.add(y * 125);
            }
        }



    }

    public void renderImage(Graphics g){



        g.setColor(Color.red);
        g.fillRect(enemy.x, enemy.y, enemy.width, enemy.height);
        boolean flag = false;
        for(int i = 0; i < num; i++){
            if(!list.get(i + count).equals(temp)) {
                flag = true;
                break;
            }
        }
        if(!flag){
            count += 5;
        }
        for (int i = 0; i < num; i++) {
            if(listX.get(i + count) > enemy.x - 90 && list.get(i + count) != temp) {
                    if(lives == 1){
                        dead = 1;
                    }
                    else{
                        lives--;
                        list.set(i + count, temp);

                    }

            }

            if(!list.get(i + count).getWord().equals(currentInput)) {
                    if(!list.get(i + count).getImage().equals(Assets.transparent)){
                        g.drawImage(list.get(i + count).getImage(), listX.get(i + count), listY.get(i + count), 90, 90, null);
                        listX.set(i + count, listX.get(i + count) + randomVelocity(min, max));

                    }
            }
            else{

                listX.set(i + count, 5);
                list.set(i + count, temp);
                score += 100;
                //num--;
                check = true;
                currentInput = "";

            }


        }
    }

    public int randomVelocity(int min, int max){
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
