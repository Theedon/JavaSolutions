package dennis;
import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.*;

public class TestGapfulNumber {
    @Test
    public void test1(){
        int inp= 192;
        Assert.assertEquals(true, GapfulNumber.forTestCase(inp));
    }

    @Test
    public void test2(){
        int inp= 583;
        Assert.assertEquals(true, GapfulNumber.forTestCase(inp));
    }

    @Test
    public void test3(){
        int inp= 210;
        Assert.assertFalse(GapfulNumber.forTestCase(inp));
    }
}
