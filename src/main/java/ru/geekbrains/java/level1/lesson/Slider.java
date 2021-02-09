package ru.geekbrains.java.level1.lesson;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slider extends JSlider {
    private JTextArea textArea;
    public Slider(JTextArea textArea) {
        super( 0, 100);
        this.textArea = textArea;
        this.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                textArea.append(String.valueOf(((Slider)e.getSource()).getValue()) + "\n");
            }
        });
    }
}
