package test.com.chepeatio.h_Index;

import com.chepeatio.h_Index.H_IndexII;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * H_IndexII Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®¶þÔÂ 25, 2015</pre>
 */
@RunWith(Parameterized.class)
public class H_IndexIITest {

    H_IndexII test = new H_IndexII();
    int[] param;
    int res;

    public H_IndexIITest(int[] parameter, int result) {
        param = parameter;
        res = result;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3,4,6}, 3},
                {new int[]{10,10,10,10,10}, 5},
                {new int[]{1,1,1,1,1}, 1},
                {new int[]{1,1,1,3,33}, 2}
        });
    }

    /**
     * Method: hIndex(int[] citations)
     */
    @Test
    public void testHIndex() throws Exception {
        Assert.assertEquals(res, test.hIndex(param));
    }
} 
