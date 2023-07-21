package dennis;
import org.junit.Test;
import org.junit.Assert;
//import static org.junit.Assert.*;
import static dennis.ZellerCongruence.*;


public class ZellerCongruenceTest {
    @Test
    public void checkIfCorrect(){
        //Assert.assertEquals("Thursday", dayOfWeek(2001, 4, 26) );
        //Assert.assertEquals("Thursday", dayOfWeek(2001, "April", 26) );
        //Assert.assertEquals("Sunday", dayOfWeek(2022, 12, 25) );
        Assert.assertEquals("Sunday", dayOfWeek(2022, "dECemBer", 25) );
    }
}
