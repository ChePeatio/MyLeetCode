package test.com.chepeatio.singleNumber;

import com.chepeatio.singleNumber.SingleNumber;
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
public class SingleNumberTest {

    SingleNumber test = new SingleNumber();
    int[] param;
    int result;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3,4,1,3,4}, 2},
                {new int[]{1,1,2,2,3,3,7}, 7},
                {new int[]{3}, 3}
        });
    }

    public SingleNumberTest(int[] param, int result) {
        this.param = param;
        this.result = result;
    }

    @Test
    public void TestSingleNumber() {
        assertEquals(result, test.singleNumber(param));
    }

    @Test
    public void TestSingleNumberBS() {
        assertEquals(result, test.singleNumberBS(param));
    }
}
