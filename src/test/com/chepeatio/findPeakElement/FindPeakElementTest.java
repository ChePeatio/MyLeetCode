package test.com.chepeatio.findPeakElement;

import com.chepeatio.findPeakElement.FindPeakElement;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * FindPeakElement Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®¶þÔÂ 17, 2015</pre>
 */
@RunWith(Parameterized.class)
public class FindPeakElementTest {

    FindPeakElement test = new FindPeakElement();
    int[] param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3,2}, 2},
                {new int[]{1,2,3,4}, 3},
                {new int[]{1,3,2,4}, 1},
                {new int[]{1,4,3,2}, 1},
                {new int[]{4,1,4,2}, 0}
        });
    }

    public FindPeakElementTest(int[] parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: findPeakElement(int[] nums)
     */
    @Test
    public void testFindPeakElement() throws Exception {
        Assert.assertEquals(res, test.findPeakElement(param));
    }
} 
