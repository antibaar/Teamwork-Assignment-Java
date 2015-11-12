package game;

import gfx.Assets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 * Created by emnemm4o on 11.11.2015 ã..
 */
public class ListOfWordWithImages {

    private ArrayList<WordWithImage> listOfWords;
    public static int numberOfPassedWords;
    public WordWithImage selectedImage;
    public static Random rand = new Random();
    public String word;

    public ListOfWordWithImages() {
        this.listOfWords = new ArrayList<WordWithImage>();
        this.numberOfPassedWords=0;
    }

    public void initFromFile() {
        listOfWords.add(new WordWithImage(Assets.adidas, "adidas"));
        listOfWords.add(new WordWithImage(Assets.amazon, "amazon"));
        listOfWords.add(new WordWithImage(Assets.angrybirds, "angry birds"));
        listOfWords.add(new WordWithImage(Assets.apple, "apple"));
        listOfWords.add(new WordWithImage(Assets.audi, "audi"));

        listOfWords.add(new WordWithImage(Assets.facebook, "facebook"));
        listOfWords.add(new WordWithImage(Assets.google, "google"));
        listOfWords.add(new WordWithImage(Assets.intel, "intel"));
        listOfWords.add(new WordWithImage(Assets.msn, "msn"));
        listOfWords.add(new WordWithImage(Assets.starwars, "star wars"));

        listOfWords.add(new WordWithImage(Assets.sega, "sega"));
        listOfWords.add(new WordWithImage(Assets.nike, "nike"));
        listOfWords.add(new WordWithImage(Assets.wikipedia, "wikipedia"));
        listOfWords.add(new WordWithImage(Assets.samsung, "samsung"));
        listOfWords.add(new WordWithImage(Assets.microsoft, "microsoft"));

        listOfWords.add(new WordWithImage(Assets.transparent, "1"));
    }

    // checks if all the words already has passed. (Can be used to define the successful end of the game)
    public boolean areAllWordsPassed()  {
    if (this.listOfWords.size()==this.numberOfPassedWords) {
        return true;
    }
    return false;
    }

    public WordWithImage getRandomWord() {
            while (this.numberOfPassedWords<this.listOfWords.size()) {
                int randomNum = rand.nextInt(this.listOfWords.size() - 1);
                if (!this.listOfWords.get(randomNum).isPassed()) {
                    this.listOfWords.get(randomNum).passWord();
                    this.numberOfPassedWords++;
                    this.selectedImage = this.listOfWords.get(randomNum);
                    //this.listOfWords.remove(randomNum);
                    word = listOfWords.get(randomNum).getWord();
                    return listOfWords.get(randomNum);
                }
            }
        return null;
    }


}

