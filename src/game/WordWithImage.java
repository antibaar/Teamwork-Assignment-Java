package game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by emnemm4o on 11.11.2015 ã..
 */
public class WordWithImage {
    private BufferedImage image;
    private String acceptedWord;
    private boolean hasPassed;

    public WordWithImage(BufferedImage image,String acceptedWord) {

        this.image = image;
        this.acceptedWord = acceptedWord;
        this.hasPassed = false;

    }

    // checks if the word has passed
    public boolean isPassed(){
        return this.hasPassed;
    }

    // make not passed word to passed
    public void passWord(){
        this.hasPassed = true;
    }

    //
    public String getWord(){
        return this.acceptedWord;
    }

    //
    public BufferedImage getImage(){
        return this.image;
    }

    // checks if an entered word by the user is correct
    public boolean isCorrectWordEntered(String enteredWord){
        if (enteredWord==this.acceptedWord) return true;
        else return false;
    }
}
