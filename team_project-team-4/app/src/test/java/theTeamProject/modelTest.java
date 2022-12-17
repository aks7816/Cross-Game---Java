
package theTeamProject;

import theTeamProject.Model.gameModel;

import org.junit.Test;
import static org.junit.Assert.*;

import java.beans.Transient;

public class modelTest {
    
    @Test 
    public void testMoveRed() {

        gameModel game1 = new gameModel();

        boolean res = game1.moveRed(22);
        
        assertEquals("Jump should be succesful" + game1, true, res );
    }

    @Test
    public void testMoveBlue() {
        gameModel game2 = new gameModel();

        boolean res = game2.moveBlue(9);
        
        assertEquals("Jump should be succesful" + game2, true, res );

    }
    
    @Test
    public void testMoveBlueTwice() {
        gameModel game3 = new gameModel();

        game3.moveBlue(9);

        boolean res = game3.moveRed(8);
        
        assertEquals("Jump should be succesful" + game3, true, res );

    }

    @Test
    public void testMoveBlocked() {
        gameModel game4 = new gameModel();

        game4.moveBlue(14);

        game4.moveBlue(19);

        boolean res = game4.moveRed(23);
        
        assertEquals("Jump should be succesful" + game4, false, res );

    }

    @Test
    public void testJumpOver() {
        gameModel game5 = new gameModel();

        game4.moveBlue(19);

        boolean res = game5.moveRed(23);
        
        assertEquals("Jump should be succesful" + game5, true, res );

    }

    @Test
    public void getPiece() {
        gameModel game6 = new gameModel();

        game6.moveBlue(19);

        game6.moveRed(23);

        int res = game6.checkSpot(13);
        
        assertEquals("Jump should be succesful" + game6, 1, res );

    }



   
}
