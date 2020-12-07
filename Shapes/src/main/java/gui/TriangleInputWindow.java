package gui;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TriangleInputWindow extends JPanel {

    JTextField fieldA = new JTextField(5);
    JTextField fieldB = new JTextField(5);
    JTextField fieldC = new JTextField(5);

    public static enum eField { FIELD_A, FIELD_B, FIELD_C }

    TriangleInputWindow() {
        setLayout(new GridLayout(3, 2));

        JLabel labelA = new JLabel("Сторона A:");
        add(labelA);
        add(fieldA);

        JLabel labelB = new JLabel("Сторона B:");
        add(labelB);
        add(fieldB);

        JLabel labelC = new JLabel("Сторона C:");
        add(labelC);
        add(fieldC);
    }

    public Map<eField, String> display() {
        int answer = JOptionPane.showConfirmDialog(null, this, "Введите стороны треугольника", JOptionPane.OK_CANCEL_OPTION);

        //"Cancel" или крестик справа сверху
        if (answer == 2 || answer == -1) return null;

        Map<eField, String> sides =  new HashMap<eField, String>();
        sides.put(eField.FIELD_A, fieldA.getText());
        sides.put(eField.FIELD_B, fieldB.getText());
        sides.put(eField.FIELD_C, fieldC.getText());

        return sides;
    }
}
