package com.chepeatio.searchInsertPosition;

import com.chepeatio.searchInsertPosition.SearchInsertPosition;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * SearchInsertPosition Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®Ò»ÔÂ 11, 2015</pre>
 */
@RunWith(Parameterized.class)
public class SearchInsertPositionTest {

    SearchInsertPosition test = new SearchInsertPosition();
    int[] param;
    int tar;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 3, 5, 6}, 5, 2},
                {new int[]{1, 3, 5, 6}, 2, 1},
                {new int[]{1, 3, 5, 6}, 7, 4},
                {new int[]{1, 3, 5, 6}, 0, 0},
                {new int[]{1,3}, 0, 0},
                {new int[]{1,3}, 2, 1}
        });
    }

    public SearchInsertPositionTest(int[] parameter, int target, int result) {
        param = parameter;
        tar = target;
        res = result;
    }

    /**
     * Method: searchInsert(int[] nums, int target)
     */
    @Test
    public void testSearchInsert() throws Exception {
        Assert.assertEquals(res, test.searchInsert(param, tar));
    }


} 
