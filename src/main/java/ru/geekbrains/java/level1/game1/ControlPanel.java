package ru.geekbrains.java.level1.game1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    private MapPanel mapPanel;
    public ControlPanel(MapPanel mapPanel) {
        super(new GridLayout(1,3));
        this.mapPanel = mapPanel;
        this.add(new RestartButton(mapPanel));
        this.add(new ChoseGameButton(mapPanel));
        this.add(new ExitButton());
    }
}

class RestartButton extends JButton {
    private MapPanel mapPanel;
    public RestartButton(MapPanel mapPanel) {
        super("Restart");
        this.mapPanel = mapPanel;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapPanel.startGame(mapPanel.getMAP_SIZE());
            }
        });
    }
}

class ChoseGameButton extends JButton {
    private MapPanel mapPanel;
    public ChoseGameButton(MapPanel mapPanel) {
        super("Chose: 5");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if (mapPanel.getMAP_SIZE() == 3){
                mapPanel.startGame(5);
            } else {
                mapPanel.startGame(3);
            }
            ((ChoseGameButton)e.getSource()).setText("Chose: " + String.valueOf(mapPanel.getMAP_SIZE() == 3 ? 5: 3));
            }
        });
    }
}

class ExitButton extends JButton {
    public ExitButton() {
        super("Exit");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
