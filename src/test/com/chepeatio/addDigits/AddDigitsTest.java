package test.com.chepeatio.addDigits;

import com.chepeatio.addDigits.AddDigits;
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
public class AddDigitsTest {

    AddDigits test = new AddDigits();
    int param;
    int result;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {38, 2},
                {1366, 7},
                {768, 3},
                {9, 9},
                {18, 9}
        });
    }

    // 构造函数，对变量进行初始化
    public AddDigitsTest(int param, int result) {
        this.param = param;
        this.result = result;
    }

    @Test
    public void TestAddDigits() {
        assertEquals(result, test.addDigits(param));
    }

    @Test
    public void TestAddDigitsBS() {
        assertEquals(result, test.addDigitsBS(param));
    }
}
