package ru.geekbrains.java.level1.lesson;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window() {
        this.setTitle("CrossesNoughts");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(300, 300, 600, 200);
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        this.add(new SouthPanel(textArea), BorderLayout.SOUTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(new TextField(textArea), BorderLayout.NORTH);
        this.add(new EastPanel(textArea), BorderLayout.EAST);
        this.setVisible(true);
    }
}
