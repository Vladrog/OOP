package gui;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class SquareInputWindow extends JPanel {

    JTextField fieldSide = new JTextField(5);

    public static enum eField { FIELD_SIDE }

    SquareInputWindow() {
        setLayout(new GridLayout(3, 2));

        JLabel labelSide = new JLabel("Длина стороны:");
        add(labelSide);
        add(fieldSide);
    }

    public Map<eField, String> display() {
        int answer = JOptionPane.showConfirmDialog(null, this, "Введите сторону квадрата", JOptionPane.OK_CANCEL_OPTION);

        //"Cancel" или крестик справа сверху
        if (answer == 2 || answer == -1) return null;

        Map<eField, String> sides =  new HashMap<eField, String>();
        sides.put(eField.FIELD_SIDE, fieldSide.getText());

        return sides;
    }
}
