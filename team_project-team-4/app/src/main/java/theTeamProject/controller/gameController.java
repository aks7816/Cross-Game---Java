package theTeamProject.controller;

import theTeamProject.View.gameView;
import theTeamProject.controllerInterface;
import theTeamProject.gameInterface;

public class gameController implements controllerInterface{

    private gameInterface theModel;
    private gameView theView;

    public gameController(gameInterface model) {
        
        this.theModel = model;
        this.theView = new gameView(this, theModel);
    }

    //If any of the buttons is clicked run through this method first.
    public boolean clicked(int x) {

        if (theModel.checkSpot(x) == 1) {
            if (theModel.moveRed(x)) {
                theModel.turnIncrement();
                return true;
            }
            else {
                return false;
            }
        }
        else if (theModel.checkSpot(x) == 2) {
            if(theModel.moveBlue(x)) {
                theModel.turnIncrement();
                return true;
            }
            else {
                return false;
            }   
        }
        else {
            return false;
        }
    }

    public int getPiece(int x) {
        return theModel.checkSpot(x);
    }

    public void reset() {
        theModel.resetGame();
    }
}

