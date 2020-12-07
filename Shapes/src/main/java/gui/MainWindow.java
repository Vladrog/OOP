package gui;

import Shapes.*;
import Shapes.Rectangle;
import Shapes.Shape;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MainWindow extends JPanel {

    private JList<String> shapesJList;

    private ArrayList<String> stringArrayList;

    private List<Shape> shapeList;

    private JPanel buttonsPanel;

    private JButton buttonMoveUp;

    private JButton buttonRemove;

    private JButton buttonCreateTriangle;

    private JButton buttonCreateRectangle;

    private JButton buttonCreateCircle;

    private JButton buttonCreateSquare;


    public MainWindow(List<Shape> shape) {
        this.shapeList = shape;
        this.stringArrayList = new ArrayList<>();
        for (Shapes.Shape sh : shapeList)
            this.stringArrayList.add(sh.toString());


        setLayout(new BorderLayout());

        initshapesJList();
        initButtonsPanel();

        add(shapesJList);
        add(buttonsPanel, BorderLayout.EAST);
    }

    private void initshapesJList() {
        shapesJList = new JList<String>(stringArrayList.toArray(new String[0]));
        shapesJList.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        shapesJList.setPreferredSize(UIConstants.listPrefSize);
    }

    private void initButtonsPanel() {
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));

        buttonMoveUp = new JButton("Поднять вверх");
        buttonMoveUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int selectedIndex = shapesJList.getSelectedIndex();
                if (selectedIndex != -1) {
                    if (selectedIndex != 0) {
                        Collections.swap(stringArrayList, selectedIndex, selectedIndex - 1);

                        Collections.swap(shapeList, selectedIndex, selectedIndex - 1);

                        shapesJList.setListData(stringArrayList.toArray(new String[0]));
                        shapesJList.setSelectedIndex(selectedIndex - 1);
                    }
                }
            }
        });

        JButton buttonMoveDown = new JButton("Опустить вниз");
        buttonMoveDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int selectedIndex = shapesJList.getSelectedIndex();
                if (selectedIndex != -1) {
                    if (selectedIndex != stringArrayList.size() - 1) {
                        Collections.swap(stringArrayList, selectedIndex, selectedIndex + 1);

                        Collections.swap(shapeList, selectedIndex, selectedIndex + 1);

                        shapesJList.setListData(stringArrayList.toArray(new String[0]));
                        shapesJList.setSelectedIndex(selectedIndex + 1);
                    }
                }
            }
        });

        buttonRemove = new JButton("Удалить");
        buttonRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int selectedIndex = shapesJList.getSelectedIndex();
                if (selectedIndex != -1) {
                    stringArrayList.remove(selectedIndex);
                    shapeList.remove(selectedIndex);
                    shapesJList.setListData(stringArrayList.toArray(new String[0]));
                }
            }
        });

        buttonCreateTriangle = new JButton("Создать треугольник");
        buttonCreateTriangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Map<TriangleInputWindow.eField, String> sides = new TriangleInputWindow().display();

                if (sides == null) return;
                else {
                    String sideAStr = sides.get(TriangleInputWindow.eField.FIELD_A);
                    String sideBStr = sides.get(TriangleInputWindow.eField.FIELD_B);
                    String sideCStr = sides.get(TriangleInputWindow.eField.FIELD_C);

                    try {
                        shapeList.add(new Triangle(
                                Double.parseDouble(sideAStr),
                                Double.parseDouble(sideBStr),
                                Double.parseDouble(sideCStr)));
                        stringArrayList.add(shapeList.get(shapeList.size() - 1).toString());
                        shapesJList.setListData(stringArrayList.toArray(new String[0]));
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());/////////////////////
                    }
                }
            }
        });

        buttonCreateRectangle = new JButton("Создать прямоугольник");
        buttonCreateRectangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Map<RectangleInputWindow.eField, String> sides = new RectangleInputWindow().display();

                if (sides == null) return;
                else {
                    String widthStr = sides.get(RectangleInputWindow.eField.FIELD_WIDTH);
                    String heightStr = sides.get(RectangleInputWindow.eField.FIELD_HEIGHT);

                    try {
                        shapeList.add(new Rectangle(
                                Double.parseDouble(widthStr),
                                Double.parseDouble(heightStr)));
                        stringArrayList.add(shapeList.get(shapeList.size() - 1).toString());
                        shapesJList.setListData(stringArrayList.toArray(new String[0]));
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());/////////////////////
                    }
                }
            }
        });

        buttonCreateCircle = new JButton("Создать круг");
        buttonCreateCircle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Map<CircleInputWindow.eField, String> sides = new CircleInputWindow().display();

                if (sides == null) return;
                else {
                    String radiusStr = sides.get(CircleInputWindow.eField.FIELD_RADIUS);

                    try {
                        shapeList.add(new Circle(
                                Double.parseDouble(radiusStr)));
                        stringArrayList.add(shapeList.get(shapeList.size() - 1).toString());
                        shapesJList.setListData(stringArrayList.toArray(new String[0]));
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());/////////////////////
                    }
                }
            }
        });

        buttonCreateSquare = new JButton("Создать квадрат");
        buttonCreateSquare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Map<SquareInputWindow.eField, String> sides = new SquareInputWindow().display();

                if (sides == null) return;
                else {
                    String sideStr = sides.get(SquareInputWindow.eField.FIELD_SIDE);

                    try {
                        shapeList.add(new Square(
                                Double.parseDouble(sideStr)));
                        stringArrayList.add(shapeList.get(shapeList.size() - 1).toString());
                        shapesJList.setListData(stringArrayList.toArray(new String[0]));
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());/////////////////////
                    }

                }
            }
        });

        buttonsPanel.add(buttonMoveUp);
        buttonsPanel.add(Box.createVerticalStrut(UIConstants.buttonsVerticalStrut));
        buttonsPanel.add(buttonMoveDown);
        buttonsPanel.add(Box.createVerticalStrut(UIConstants.buttonsVerticalStrut));
        buttonsPanel.add(buttonRemove);
        buttonsPanel.add(Box.createVerticalStrut(UIConstants.buttonsVerticalStrut));
        buttonsPanel.add(buttonCreateTriangle);
        buttonsPanel.add(Box.createVerticalStrut(UIConstants.buttonsVerticalStrut));
        buttonsPanel.add(buttonCreateRectangle);
        buttonsPanel.add(Box.createVerticalStrut(UIConstants.buttonsVerticalStrut));
        buttonsPanel.add(buttonCreateCircle);
        buttonsPanel.add(Box.createVerticalStrut(UIConstants.buttonsVerticalStrut));
        buttonsPanel.add(buttonCreateSquare);
        buttonsPanel.setBorder(new EmptyBorder(0, UIConstants.buttonsLeftIndent, 0, 0));
        buttonsPanel.setPreferredSize(UIConstants.buttonsPanelPrefSize);
    }
}
