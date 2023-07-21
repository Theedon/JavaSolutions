package dennis;
import org.junit.Test;
import org.junit.Assert;

public class MaxDiffTest {
    MaxDiff maxDiff= new MaxDiff();

    @Test
    public void Test1(){
        int[] a= {3,1,4,1,5,9,2};
        int[] b= {9,4,6,8,2,2};

        Assert.assertEquals(8, maxDiff.slow(a));
        Assert.assertEquals(8, maxDiff.fast(a));
    }

    @Test
    public void Test2(){
        int[] b= {9,4,6,8,2,2};
        Assert.assertEquals(4, maxDiff.slow(b));
        Assert.assertEquals(4, maxDiff.fast(b));
    }

    @Test
    public void Test3(){
        int[] c= {5,6,3,2,8,6,4,3,8,0,7,5};
        Assert.assertEquals(7, maxDiff.slow(c));
        Assert.assertEquals(7, maxDiff.fast(c));
    }
}
