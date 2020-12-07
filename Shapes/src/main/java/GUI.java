import Functional.RWHelper;
import gui.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class GUI {


    public void run() {
        JFrame frame = new JFrame("Shapes app");
        frame.setSize(new Dimension(1360, 1200));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



        List<Shapes.Shape> shapes = (List<Shapes.Shape>)(RWHelper.Read());

        frame.add(new MainWindow(shapes));
        frame.setVisible(true);




        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                RWHelper.Write(shapes);
                e.getWindow().dispose();
            }
        });
    }

    public static void main(String[] args) {

        new GUI().run();
    }
}
