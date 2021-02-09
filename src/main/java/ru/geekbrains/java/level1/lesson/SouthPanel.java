package ru.geekbrains.java.level1.lesson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SouthPanel extends JPanel {
    private JTextArea textArea;
    public SouthPanel(JTextArea textArea) {
        super(new GridLayout(1,10,5,0));
        this.textArea = textArea;
//        this.setBorder(BorderFactory.createTitledBorder("res"));
        for (int i = 0; i <=9; i++){
            JButton button = new JButton(String.valueOf(i));
            this.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.append(((JButton)e.getSource()).getText() + "\n");
                }
            });

        }

    }
}

