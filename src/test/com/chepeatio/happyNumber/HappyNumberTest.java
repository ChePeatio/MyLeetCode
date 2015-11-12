package test.com.chepeatio.happyNumber;

import com.chepeatio.happyNumber.HappyNumber;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * HappyNumber Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®Ò»ÔÂ 12, 2015</pre>
 */
@RunWith(Parameterized.class)
public class HappyNumberTest {

    HappyNumber test = new HappyNumber();
    int param;
    boolean res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {1, true},
                {19, true}
        });
    }

    public HappyNumberTest(int parameter, boolean result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: isHappy(int n)
     */
    @Test
    public void testIsHappy() throws Exception {
        Assert.assertEquals(res, test.isHappy(param));
    }
} 
