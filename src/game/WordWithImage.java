package game;

import java.awt.image.BufferedImage;

public class WordWithImage {
    private BufferedImage image;
    private String acceptedWord;
    private boolean hasPassed;

    public WordWithImage(BufferedImage image,String acceptedWord) {

        this.image = image;
        this.acceptedWord = acceptedWord;
        this.hasPassed = false;

    }

    public boolean isPassed(){
        return this.hasPassed;
    }

    public void passWord(){
        this.hasPassed = true;
    }

    public String getWord(){
        return this.acceptedWord;
    }

    public BufferedImage getImage(){
        return this.image;
    }

}
