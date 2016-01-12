package test.com.chepeatio.containsDuplicate;

import com.chepeatio.containsDuplicate.ContainsDuplicateII;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * ContainsDuplicateII Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>Ò»ÔÂ 12, 2016</pre>
 */
@RunWith(Parameterized.class)
public class ContainsDuplicateIITest {

    ContainsDuplicateII test = new ContainsDuplicateII();
    int[] param1;
    int param2;
    boolean res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,1,2,2,3,3,4}, 0, false},
                {new int[]{1,2,3,4,3,2,1}, 6, true},
                {new int[]{1,2,3,4,3,2,1}, 3, true},
                {new int[]{1,2,3,4,3,2,1}, 10, true},
                {new int[]{1,2,3,4,5,6,7}, 5, false}
        });
    }

    public ContainsDuplicateIITest(int[] parameter1, int parameter2, boolean result) {
        param1 = parameter1;
        param2 = parameter2;
        res = result;
    }

    /**
     * Method: containsNearbyDuplicate(int[] nums, int k)
     */
    @Test
    public void testContainsNearbyDuplicate() throws Exception {
        Assert.assertEquals(res, test.containsNearbyDuplicate(param1, param2));
    }
} 
