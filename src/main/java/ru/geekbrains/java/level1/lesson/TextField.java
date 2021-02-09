package ru.geekbrains.java.level1.lesson;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextField extends JTextField {
    private JTextArea textArea;
    public TextField(JTextArea textArea) {
        super();
        this.textArea = textArea;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append(((TextField)e.getSource()).getText() + "\n");
                ((TextField)e.getSource()).setText("");
            }
        });
    }
}
