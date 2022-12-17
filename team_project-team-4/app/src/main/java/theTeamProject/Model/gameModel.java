package theTeamProject.Model;

import java.util.ArrayList;

import theTeamProject.gameObserver;
import theTeamProject.gameInterface;

public class gameModel implements gameInterface{

    int[] arr = new int[25];

    //Just for reference as to what the pieces are.
    int redL = 21;
    int redM = 22;
    int redR = 23;

    int blueT = 9;
    int blueM = 14;
    int blueB = 19;

    int turn = 0; //Even turn for Red, Odd turn for Blue

    public ArrayList<gameObserver> observers;

    public gameModel() {
        this.arr[redL] = 1;
        this.arr[redM] = 1;
        this.arr[redR] = 1;

        this.arr[blueT] = 2;
        this.arr[blueM] = 2;
        this.arr[blueB] = 2;
        this.observers = new ArrayList<gameObserver>();
    }

    public void resetGame() {
        for (int i = 0; i < 25; i++) {
            arr[i] = 0;
        }
        arr[redL] = 1;
        arr[redM] = 1;
        arr[redR] = 1;

        arr[blueT] = 2;
        arr[blueM] = 2;
        arr[blueB] = 2;
        
    }

    public int checkTurn() {
        return turn;
    }

    public int checkSpot(int x) {
        return arr[x];
    }

    public void turnIncrement() {
        turn++;
    }

    public boolean moveRed(int x) {

        if (arr[x - 5] == 0) {
            arr[x] = 0; //Clear that tile
            x -= 5;
            arr[x] = 1; //Set that new tile to 1
            return true;
        }
        else if (arr[x - 10] == 0) {
            arr[x] = 0;
            x -= 10;
            arr[x] = 1;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean moveBlue(int x) {
        if (arr[x - 1] == 0) {
            arr[x] = 0; //Clear that tile
            x -= 1;
            arr[x] = 2; //Set that new tile to 1
            return true;
        }
        else if (arr[x - 2] == 0) {
            arr[x] = 0;
            x -= 2;
            arr[x] = 2;
            return true;
        }
        else {
            return false;
        }
    }


    public void printLine() {
        for (int i = 0; i < 25; i++) {
             if (i == 4 || i == 9 || i == 14 || i == 19) {
                 System.out.println( arr[i] + " ");
             } 
             else {
                 System.out.print(arr[i] + " ");
             }
         }
         System.out.println("");
     }

     @Override
     public void register(gameObserver observer) {
        observers.add(observer);
     }

     @Override
     public void unregister(gameObserver observer) {
        observers.add(observer);
     }

     @Override
     public void notifyObservers() {
        for (gameObserver g: observers) {
            g.update();
        }
     }
}

