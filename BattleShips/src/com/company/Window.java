package com.company;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private final int width,height;
    private final AL AL;
    Board playerBoard,computerBoard;
    public Window(String title,int width, int height,Board playerBoard,Board computerBoard,Main main) {
        super(title);
        System.out.println("Initializing Window...");
        this.playerBoard=playerBoard;
        this.computerBoard=computerBoard;
        this.AL=new AL(computerBoard,main);
        this.height=height;
        this.width=width;
        setLayout(new FlowLayout());
        createWindow();
    }

    private void createWindow(){
        getContentPane().setPreferredSize(new Dimension(width,height));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        computerBoard.addMouseListener(AL);
        add(playerBoard);
        add(computerBoard);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
