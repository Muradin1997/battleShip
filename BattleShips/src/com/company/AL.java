package com.company;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AL implements MouseListener {
    private final Board board;
    private final Main main;
    public AL(Board board,Main main){
        this.board=board;
        this.main=main;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (main.isDead()) {
            System.out.println("Game over");
        } else {
            if (main.getTurn() == 1) {
                Point p = e.getPoint();
                for (int i = board.singleCellHeight; i < board.resolution; i += board.singleCellHeight) {           // Creating square fields
                    for (int j = board.singleCellHeight; j < board.resolution; j += board.singleCellHeight) {
                        if ((p.x >= i && p.x <= i + board.singleCellHeight) && p.y >= j && p.y <= j + board.singleCellHeight) {
                            System.out.println("Shoot  at " + i / 70 + " " + j / 70);
                            main.shoot(i / 70, j / 70);
                        }
                    }
                }
            } else if (main.getTurn() == 0) {
                System.out.println("COMPUTER SHOOTING ");
                main.shoot(main.rand(), main.rand());
            }
        }
    }
        @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

