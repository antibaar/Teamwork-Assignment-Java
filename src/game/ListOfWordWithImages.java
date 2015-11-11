package game;

import gfx.Assets;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by emnemm4o on 11.11.2015 ã..
 */
public class ListOfWordWithImages {

    private ArrayList<WordWithImage> listOfWords;
    public static int numberOfPassedWords;
    public WordWithImage selectedImage;

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
                Random rand = new Random();
                int randomNum = rand.nextInt(this.listOfWords.size() - 1);
                if (!this.listOfWords.get(randomNum).isPassed()) {
                    this.listOfWords.get(randomNum).passWord();
                    this.numberOfPassedWords++;
                    this.selectedImage = this.listOfWords.get(randomNum);
                    //this.listOfWords.remove(randomNum);
                    return listOfWords.get(randomNum);
                }
            }
        return null;
    }


}

