package test.com.chepeatio.searchInRotatedSortedArray; 

import com.chepeatio.searchInRotatedSortedArray.SearchInRotatedSortedArrayII;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/** 
* SearchInRotatedSortedArrayII Tester. 
* 
* @author <Authors name> 
* @since <pre>Ê®¶þÔÂ 28, 2015</pre> 
* @version 1.0 
*/
@RunWith(Parameterized.class)
public class SearchInRotatedSortedArrayIITest { 

    SearchInRotatedSortedArrayII test = new SearchInRotatedSortedArrayII();
    int[] param1;
    int param2;
    boolean res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 3, 1, 1, 1}, 3, true},
                {new int[]{3, 5, 6, 7, 9, 0, 1, 2}, 6, true},
                {new int[]{3, 5, 7, 9, 0, 0, 0, 1, 2}, 100, false},
                {new int[]{3, 5, 7, 9, 0, 1, 2, 3, 3}, 3, true},
                {new int[]{3, 3,3,3,3,3,3,3,3,5, 7, 9, 0, 1, 2}, 9, true},
        });
    }

    public SearchInRotatedSortedArrayIITest(int[] parameter1, int parameter2, boolean result) {
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
