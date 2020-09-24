package com.company;

import java.util.ArrayList;

public class Main {
    ArrayList<Ship> playerShips;
    ArrayList<Ship> computerShips;
Board player;
Board computer;
    public Main() {
        String title = "Battle Ships";
        int resolution = 70*11;
        playerShips = new ArrayList<>();
        computerShips = new ArrayList<>();
        createShipsArrays();
        placeShipsOnBoard(playerShips);
        placeShipsOnBoard(computerShips);
        player = new Board(resolution,playerShips);
        computer = new Board(resolution,computerShips);
        Window window = new Window(title, resolution*2+50,resolution, player, computer,this);
    }

    public static void main(String[] args) {
        Main main=new Main();
    }
    private void createShipsArrays(){
        int shipsNeeded=1;
        for(int i=4;i>0;i--) {
            for (int j=1; j<=shipsNeeded; j++) {
                playerShips.add(new Ship(i));
                computerShips.add(new Ship(i));
            }shipsNeeded++;
        }
    }

    private void placeShipsOnBoard(ArrayList<Ship>shipArrayList){
        int rows=10;
        int cols=10;
        for(Ship s:shipArrayList){
            boolean horizontal=((int)(Math.random()*10) %2==1);        // true horizontal, false vertical
            int rowmax=horizontal?rows-1:rows-s.getSize();
            int colmax=horizontal?cols-s.getSize():cols-1;
            int startRow=rand() % rowmax+1;
            int startCol=rand() % colmax+1;
            int i;
            for(i=0 ;i<s.getSize() ; i++) {
                s.xyPositions.add(startRow + (horizontal ? 0 : i));
                s.xyPositions.add(startCol + (horizontal ? i : 0));
            }
        }
    }

    public void shoot(int x,int y){
        boolean shoot=false;
        for(Ship s:turn==1?computerShips:playerShips){
            for(int i=0;i<s.xyPositions.size();i+=2){
                if(s.xyPositions.get(i)==x&&s.xyPositions.get(i+1)==y){
                    System.out.println("HIT!");
                    if (turn == 1) {
                        computer.update(computer.getGraphics(), s.xyPositions.get(i),s.xyPositions.get(i+1) );
                    } else {
                        player.update(player.getGraphics(),s.xyPositions.get(i),s.xyPositions.get(i+1));
                    }
                    s.xyPositions.remove(i);
                    s.xyPositions.remove(i);
                    shoot=true;
                    break;
                }
            }
        }if(!shoot){
            System.out.println("MISS!");
            changeTurn();
        }
    }


    private int turn=1;
private void changeTurn(){
        turn=turn==1?0:1;
}
    public int getTurn() {
        return turn;
    }

public int rand(){
        return (int)(Math.random()*10);
}

    public boolean isDead(){
    if(!player.isAlive()){
        System.out.println("Computer won!");
        return true;
    }else if(!computer.isAlive()){
        System.out.println("Player won!");
        return true;
    }return false;
    }

}

