package test.com.chepeatio.singleNumber;

import com.chepeatio.singleNumber.SingleNumberIII;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by CheKedar on 2015/10/20.
 */
@RunWith(Parameterized.class)
public class SingleNumberIIITest {

    SingleNumberIII test = new SingleNumberIII();
    int[] param;
    int[] result;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3,4,1,3,4,5}, new int[]{5,2}},
                {new int[]{1,1,2,2,3,3,7,4}, new int[]{7,4}},
                {new int[]{3,4}, new int[]{3,4}}
        });
    }

    public SingleNumberIIITest(int[] param, int[] result) {
        this.param = param;
        this.result = result;
    }

    @Test
    public void TestSingleNumber() {
        Assert.assertArrayEquals(result, test.singleNumber(param));
    }

    @Test
    public void TestSingleNumberBS() {
        Assert.assertArrayEquals(result, test.singleNumberBS(param));
    }
}
