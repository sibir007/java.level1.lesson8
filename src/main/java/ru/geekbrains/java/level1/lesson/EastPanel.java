package ru.geekbrains.java.level1.lesson;

import javax.swing.*;
import java.awt.*;

public class EastPanel extends JPanel {
    private JTextArea textArea;
    public EastPanel(JTextArea textArea) {
        super(new GridLayout(2,1));
        this.textArea = textArea;
        this.add(new Slider(this.textArea));
        this.add(new ClearButton(this.textArea));
    }
}
