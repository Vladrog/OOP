package gui;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class RectangleInputWindow extends JPanel {

    JTextField fieldWidth = new JTextField(5);
    JTextField fieldHeight = new JTextField(5);

    public static enum eField { FIELD_WIDTH, FIELD_HEIGHT }

    RectangleInputWindow() {
        setLayout(new GridLayout(3, 2));

        JLabel labelWidth = new JLabel("Ширина:");
        add(labelWidth);
        add(fieldWidth);

        JLabel labelHeight = new JLabel("Высота:");
        add(labelHeight);
        add(fieldHeight);
    }

    public Map<eField, String> display() {
        int answer = JOptionPane.showConfirmDialog(null, this, "Введите ширину и высоту прямоугольника", JOptionPane.OK_CANCEL_OPTION);

        //"Cancel" или крестик справа сверху
        if (answer == 2 || answer == -1) return null;

        Map<eField, String> sides =  new HashMap<eField, String>();
        sides.put(eField.FIELD_WIDTH, fieldWidth.getText());
        sides.put(eField.FIELD_HEIGHT, fieldHeight.getText());

        return sides;
    }
}
