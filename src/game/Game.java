package game;

import display.Display;
import gfx.Assets;
import gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable{
    private Display display;
    public int width, height;
    public String title;
    private LogoSpawner logoSpawner;

    private ListOfWordWithImages listOfWordWithImages;

    private boolean running;
    private Thread thread;

    private boolean check;
    private BufferStrategy bs;
    private Graphics g;

    private BufferedImage background;


    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.listOfWordWithImages = new ListOfWordWithImages();
    }

    private void init() {
        display = new Display(this.title, this.width, this.height);
        background = ImageLoader.loadImage("/textures/bckg.png");
        this.display.getCanvas().addKeyListener(new InputHandler(this.display));
        Assets.init();

        listOfWordWithImages.initFromFile();

        this.logoSpawner = new LogoSpawner(listOfWordWithImages);

    }


    private void render() {
        this.bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(2);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, this.width, this.height);


        g.drawImage(background, 0, 0, this.width, this.height, null);


        Font font2 = new Font("arial", Font.BOLD, 30);
        g.setFont(font2);
        g.setColor(Color.BLACK);
        g.drawString("Score: " + logoSpawner.score, 10, 705);
        g.drawString("Lives: " + (logoSpawner.lives - 1), 310, 705);

        if(check){
            stop();
        }
        else{
            logoSpawner.renderImage(g);
        }

        if(logoSpawner.score - logoSpawner.lives * 100 >= 1200){
            Font font = new Font("arial", Font.BOLD, 60);
            g.setFont(font);
            g.setColor(Color.GREEN);
            g.drawString("You win!", 500, 300);
            check = true;
        }
        if(logoSpawner.dead == 1){
            Font font = new Font("arial", Font.BOLD, 60);
            g.setFont(font);
            g.setColor(Color.RED);
            g.drawString("You lose!", 500, 300);
            check = true;
        }
        
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();

        int fps = 60;

        double timePerTick = 1_000_000_000.0 / fps;

        double delta = 0;

        long now;

        long lastTime = System.nanoTime();


        while (running) {

            now = System.nanoTime();

            delta += (now-lastTime) / timePerTick;
            lastTime = now;

            if (delta >= 1) {
                render();
                delta--;
            }

        }

        stop();
    }

    public synchronized void start() {

        if(running) {
            return;
        }

        running = true;

        thread = new Thread(this);


        thread.start();
    }


    public synchronized void stop() {

        if(!running) {
            return;
        }
        running = false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
