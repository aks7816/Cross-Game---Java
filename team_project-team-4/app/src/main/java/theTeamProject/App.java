package theTeamProject;

import java.util.Scanner;

import theTeamProject.Model.gameModel;
import theTeamProject.controller.gameController;

public class App {
    public static void main(String[] args)  {
        gameModel t = new gameModel();
        gameController c = new gameController(t);

    }

}

