package com.chepeatio.removeDuplicatesFromSortedList;

import com.chepeatio.removeDuplicatesFromSortedList.RemoveDuplicatesFromSortedList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * RemoveDuplicatesFromSortedList Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®Ò»ÔÂ 17, 2015</pre>
 */
@RunWith(Parameterized.class)
public class RemoveDuplicatesFromSortedListTest {

    RemoveDuplicatesFromSortedList test = new RemoveDuplicatesFromSortedList();
    int[] param;
    int[] res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{}, new int[]{}},
                {new int[]{1,1,2}, new int[]{1,2}},
                {new int[]{1,1,2,3,3}, new int[]{1,2,3}}
        });
    }

    public RemoveDuplicatesFromSortedListTest(int[] parameter, int[] result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: deleteDuplicates(ListNode head)
     */
    @Test
    public void testDeleteDuplicates() throws Exception {
        Assert.assertArrayEquals(res, test.getArray(test.deleteDuplicates(test.generateList(param))));
    }
} 
