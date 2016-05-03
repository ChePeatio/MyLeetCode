package test.com.chepeatio.countAndSay;

import com.chepeatio.countAndSay.CountAndSay;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * CountAndSay Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ÎåÔÂ 3, 2016</pre>
 */
@RunWith(Parameterized.class)
public class CountAndSayTest {

    CountAndSay test = new CountAndSay();
    int param;
    String res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {1, "1"},
                {4, "1211"},
                {10, "13211311123113112211"}
        });
    }

    public CountAndSayTest(int parameter, String result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: countAndSay(int n)
     */
    @Test
    public void testCountAndSay() throws Exception {
        Assert.assertEquals(res, test.countAndSay(param));
    }
} 
