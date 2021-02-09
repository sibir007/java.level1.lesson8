package ru.geekbrains.java.level1.lesson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearButton extends JButton {
    private JTextArea textArea;
    public ClearButton(JTextArea textArea) {
        super("Clear");
        this.textArea = textArea;
        this.setBackground(Color.BLUE);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
    }
}
