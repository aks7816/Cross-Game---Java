package main.java.theTeamProject.View;

import theTeamProject.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class scoreView {

    String fileName = "score.txt";
    String highscore;

    public void read() {
        File fullFile = new File(fileName);
        Scanner scanner;
        try {
            scanner = new Scanner(fullFile);
                String nextLine = scanner.nextLine();
                this.highscore = nextLine;             
      }
      catch (FileNotFoundException error){
         System.out.println("ERROR File not found!");
      }
    }

    public String returnScore() {
        return this.highscore;
    }

    public void checkCount(int steps) {
        if (steps < Integer.parseInt(highscore)) {
            overwrite(steps); 
            System.out.print(steps);
        }
    }

    public void overwrite(int steps) {
        Scanner scanner= new Scanner(fileName);
        StringBuffer buffer = new StringBuffer();

        while(scanner.hasNextLine()){
            buffer.append(scanner.nextLine()+ System.lineSeparator());
        }
        String fileContents= buffer.toString();
        scanner.close();
        String step2 = Integer.toString(steps);
        try{
            fileContents= fileContents.replaceAll(highscore, step2);
            FileWriter writer= new FileWriter(fileName);
            writer.append(step2);
            writer.flush();
        }
        catch(Exception e){
            System.out.println("Something went wrong ");
        }   
    }    
}
