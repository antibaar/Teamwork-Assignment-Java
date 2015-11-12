package display;

import javax.swing.*;
import java.awt.*;

public class Display extends Canvas{
    private JFrame frame;

    private Canvas canvas;

    private String title;
    private int width, height;

    public JTextField getField() {
        return field;
    }


    private JTextField field = new JTextField(10);

    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;


        createDisplay();
    }
    public Display(JTextField field){
        this.field = field;
    }



    private void createDisplay() {

        frame = new JFrame(this.title);

        frame.setSize(this.width, this.height);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setResizable(false);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        frame.setFocusable(true);

        frame.add(field, BorderLayout.SOUTH);

        field.requestFocus();


        canvas = new Canvas();

        canvas.setPreferredSize(new Dimension(width, height));

        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));


        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas() {
        return this.canvas;
    }
}
