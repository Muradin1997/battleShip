package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {
    ArrayList<Ship> ships;
    int resolution, cellCenter, singleCellHeight;

    public Board(int resolution, ArrayList<Ship> ships) {
        System.out.println("Creating Board...");
        this.ships = ships;
        this.resolution = resolution;
        cellCenter = (resolution / 11) / 2;
        singleCellHeight = resolution / 11;
        setPreferredSize(new Dimension(resolution, resolution));
    }

    public void update(Graphics g,int x,int y) {
        super.update(g);
        g.setColor(Color.RED);
        g.fillOval(x*70,y*70,70,70);
    }

    @Override
    public void paint(Graphics g) {
        int l = 1;
        String letters = "ABCDEFGHIJ";
        for (int i = singleCellHeight; i < resolution; i += singleCellHeight) {
            g.drawString(Integer.toString(l), i + cellCenter, cellCenter);  // Creating ABC... columns
            g.drawString(Character.toString(letters.charAt(l - 1)), cellCenter, i + cellCenter);  // Creating 123... rows
            l++;
        }
        for (int i = singleCellHeight; i < resolution; i += singleCellHeight) {           // Creating square fields
            for (int j = singleCellHeight; j < resolution; j += singleCellHeight) {
                g.setColor(Color.BLACK);
                g.drawRect(i-1, j, singleCellHeight, singleCellHeight);
            }
        }
        for(Ship s:ships){                      // Creating ships
          for(int i=0;i<s.xyPositions.size();i+=2){
              g.setColor(Color.BLUE);
              g.fillOval(s.xyPositions.get(i)*70,s.xyPositions.get(i+1)*70,singleCellHeight,singleCellHeight);
          }
        }
    }


    public boolean isAlive(){
        int i=0;
        for(Ship s:ships){
            for(int n:s.xyPositions){
                i++;
            }
        }
        return i>0;
    }
}