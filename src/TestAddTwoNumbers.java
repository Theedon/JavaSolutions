package dennis;
import org.junit.Test;

import static org.junit.Assert.*;

//import static org.junit.jupiter.api.Assertions.*;

public class TestAddTwoNumbers {
    AddTwoNumbers add= new AddTwoNumbers();
    @Test
        public void testCase1(){
        //int x=1, y=2;
        for(int x= 0, y=0; x<10; x++,y++) {
            assertEquals(x+y, add.addTwo(x, y));
        }
    }
    @Test
        public void testCase2(){
        int x= 22, y=48;
        assertEquals(70, add.addTwo(x,y));
    }
}
