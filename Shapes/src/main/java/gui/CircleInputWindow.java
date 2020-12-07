package gui;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CircleInputWindow extends JPanel {

    JTextField fieldRadius = new JTextField(5);

    public static enum eField { FIELD_RADIUS }

    CircleInputWindow() {
        setLayout(new GridLayout(3, 2));

        JLabel labelWidth = new JLabel("Радиус:");
        add(labelWidth);
        add(fieldRadius);
    }

    public Map<eField, String> display() {
        int answer = JOptionPane.showConfirmDialog(null, this, "Введите радиус круга", JOptionPane.OK_CANCEL_OPTION);

        //"Cancel" или крестик справа сверху
        if (answer == 2 || answer == -1) return null;

        Map<eField, String> sides =  new HashMap<eField, String>();
        sides.put(eField.FIELD_RADIUS, fieldRadius.getText());

        return sides;
    }
}
