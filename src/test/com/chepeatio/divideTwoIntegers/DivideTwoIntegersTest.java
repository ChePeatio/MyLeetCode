package test.com.chepeatio.divideTwoIntegers;

import com.chepeatio.divideTwoIntegers.DivideTwoIntegers;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by CheKedar on 2015/10/19.
 */
@RunWith(Parameterized.class)
public class DivideTwoIntegersTest {

    private DivideTwoIntegers test = new DivideTwoIntegers();
    private int dividend;
    private int divisor;
    private int result;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {38, 19, 2},
                {1366, 7, 195},
                {768, 3335, 0},
                {9, 9, 1},
                {18, 0, Integer.MAX_VALUE},
                {1, -1, -1},
                {10, -1, -10},
                {10, -12, 0},
                {-1, -1, 1},
                {-5, -1, 5},
                {-2, -4, 0},
                {-4, 3, -1},
                {2147483647, 1, 2147483647},
                {2147483647, 3, 715827882},
                {-2147483648, -2147483648, 1},
                {-2147483648, -1, Integer.MAX_VALUE},
                {-2147483648, 1, -2147483648}
        });
    }

    // 构造函数，对变量进行初始化
    public DivideTwoIntegersTest(int dividend, int divisor, int result) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.result = result;
    }

    @Test
    public void TestAddDigits() {
        assertEquals(result, test.divide(dividend, divisor));
    }

    @Ignore
    @Test
    public void TestAddDigitsBS() {
        assertEquals(result, test.divideBS(dividend, divisor));
    }
}