package matc.madjava.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunctionsTest {

    @Test
    public void testTotalPointsFunction(){
        Functions function = new Functions();
        long testNum = function.calculateTotalPoints(1,1,1,1,1);
        assertEquals(5, testNum, "numbers dont match");

    }

    @Test void testPlayerPointsFunction() {
        Functions function = new Functions();
        long testNum = function.calculatePlayerPoints(1, 10, 2,1,1,1);
        assertEquals(21,testNum, "did not equal the correct number");

    }

}