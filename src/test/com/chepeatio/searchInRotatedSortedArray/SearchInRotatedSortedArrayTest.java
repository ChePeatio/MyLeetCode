package test.com.chepeatio.searchInRotatedSortedArray;

import com.chepeatio.searchInRotatedSortedArray.SearchInRotatedSortedArray;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * SearchInRotatedSortedArray Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®¶þÔÂ 28, 2015</pre>
 */
@RunWith(Parameterized.class)
public class SearchInRotatedSortedArrayTest {

    SearchInRotatedSortedArray test = new SearchInRotatedSortedArray();
    int[] param1;
    int param2;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{3,5,7,9,0,1,2}, 2, 6},
                {new int[]{3,5,7,9,0,1,2}, 6, -1},
                {new int[]{3,5,7,9,0,1,2}, 100, -1},
                {new int[]{3,5,7,9,0,1,2}, 3, 0},
                {new int[]{3,5,7,9,0,1,2}, 9, 3},
        });
    }

    public SearchInRotatedSortedArrayTest(int[] parameter1, int parameter2, int result) {
        param1 = parameter1;
        param2 = parameter2;
        res = result;
    }

    /**
     * Method: search(int[] nums, int target)
     */
    @Test
    public void testSearch() throws Exception {
        Assert.assertEquals(res, test.search(param1, param2));
    }
} 
