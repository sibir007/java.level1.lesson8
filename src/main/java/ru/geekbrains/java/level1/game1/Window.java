package ru.geekbrains.java.level1.game1;

import javax.swing.*;

public class Window extends JFrame {
    public Window() {
        this.setTitle("XO");
        this.setBounds(200,200,400,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(new MapPanel());
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Window();
    }
}
