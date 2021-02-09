package ru.geekbrains.java.level1.game1;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window() {
        this.setTitle("XO");
        this.setBounds(200,200,317,366);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        MapPanel mapPanel = new MapPanel(3);
        this.add(mapPanel);
        this.add(new ControlPanel(mapPanel), BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Window();
    }
}
