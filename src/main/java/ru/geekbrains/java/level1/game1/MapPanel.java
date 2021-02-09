package ru.geekbrains.java.level1.game1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MapPanel extends JPanel {
    private final int CELL_SIZE = 100;
    private final int MAP_SIZE = 5;
    private byte dot = 1;

    private byte[][] map;
    private byte winByte = 0;

    public MapPanel() {
        this.map = new byte[MAP_SIZE][MAP_SIZE];
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
//                super.mouseReleased(e);
                if (winByte == 0) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
//                    System.out.println("1");
                        int cellX = e.getX() / CELL_SIZE;
                        int cellY = e.getY() / CELL_SIZE;
                        if (cellX < MAP_SIZE && cellY < MAP_SIZE) {
                            setDot(cellX, cellY);
                        }


                    }
                }
            }
        });
    }

    private void setDot(int cellX, int cellY) {
        if (cellX > 0 || cellY > 0 || cellY <= MAP_SIZE || cellY <= MAP_SIZE) {
            if (map[cellX][cellY] == 0) {
                map[cellX][cellY] = dot;
                dot = (byte) (dot == 1 ? 2 : 1);
                repaint();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, CELL_SIZE * MAP_SIZE, CELL_SIZE * MAP_SIZE);
        g.setColor(Color.BLACK);
        ((Graphics2D) g).setStroke(new BasicStroke(3));
        for (int i = 0; i <= MAP_SIZE; i++) {
            g.drawLine(0, i * CELL_SIZE, CELL_SIZE * MAP_SIZE, i * CELL_SIZE);
            g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, CELL_SIZE * MAP_SIZE);
        }
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[i][j] == 1) {
                    g.drawOval(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                } else if (map[i][j] == 2) {
                    g.drawLine(i * CELL_SIZE, j * CELL_SIZE, i * CELL_SIZE + CELL_SIZE, j * CELL_SIZE + CELL_SIZE);
                    g.drawLine(i * CELL_SIZE, j * CELL_SIZE + CELL_SIZE, i * CELL_SIZE + CELL_SIZE, j * CELL_SIZE);
                }


            }

        }

        if (checkWin()) {
            g.drawString("WIN " + (winByte == 1 ? "0" : "X"), MAP_SIZE * CELL_SIZE / 2, MAP_SIZE * CELL_SIZE / 2);
        } else if (checkMapFilling()) {
            g.drawString("DRAW", MAP_SIZE * CELL_SIZE / 2, MAP_SIZE * CELL_SIZE / 2);
        }

    }

    /**
     * Проверка выиигрыша
     */
    private boolean checkWin() {
        if (checkHor() || checkVer() || checkDiag()) {
            return true;
        }
        return false;
    }

    /**
     * Проверка выиигрыша по горизонталям
     */
    private boolean checkHor() {
        boolean check = false;
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[i][j] == 0) {
                    break;
                }
                if (map[i][j] != map[i][0]) {
                    break;
                }
                if (j == MAP_SIZE - 1) {
                    check = true;
                    winByte = map[i][j];
                    break;
                }
            }
            if (check) {
                break;
            }
        }
        return check;
    }

    /**
     * Проверка выиигрыша по вертикалям
     */
    private boolean checkVer() {
        boolean check = false;
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[j][i] == 0) {
                    break;
                }
                if (map[j][i] != map[0][i]) {
                    break;
                }
                if (j == MAP_SIZE - 1) {
                    check = true;
                    winByte = map[j][i];
                    break;
                }
            }
            if (check) {
                break;
            }
        }
        return check;
    }

    /**
     * Проверка выиигрыша по диогоналям
     */
    private boolean checkDiag() {
        boolean check = false;
        for (int i = 0; i < MAP_SIZE; i++) {
            if (map[i][i] == 0) {
                break;
            }
            if (map[i][i] != map[0][0]) {
                break;
            }
            if (i == MAP_SIZE - 1) {
                check = true;
                winByte = map[i][i];
                break;
            }
        }
        if (check) {
            return true;
        }
        for (int i = MAP_SIZE - 1; i >= 0; i--) {
            if (map[i][MAP_SIZE - 1 - i] == 0) {
                break;
            }
            if (map[i][MAP_SIZE - 1 - i] != map[MAP_SIZE - 1][0]) {
                break;
            }
            if (i == 0) {
                check = true;
                winByte = map[i][MAP_SIZE - 1 - i];
                break;
            }
        }
        return check;
    }

    /**
     * Проверка на заполненность игорового поля
     */
    private boolean checkMapFilling() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
