package com.chepeatio.sortList;

import com.chepeatio.utils.ListNode;
import com.chepeatio.sortList.SortList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * SortList Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>Ê®Ò»ÔÂ 6, 2015</pre>
 */
@RunWith(Parameterized.class)
public class SortListTest {

    private SortList test = new SortList();
    private int[] param;
    private int[] res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 4, 1, 3, 4, 5}, new int[]{1,1,2,3,3,4,4,5}},
                {new int[]{1, 1, 2, 2, 3, 3, 7, 4}, new int[]{1,1,2,2,3,3,4,7}},
                {new int[]{3, 4}, new int[]{3, 4}},
                {new int[]{3,7,1,4,0,5,1}, new int[]{0,1,1,3,4,5,7}},
                {new int[]{1}, new int[]{1}}
        });
    }

    public SortListTest(int[] parameter, int[] result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: sortList(ListNode head)
     */
    @Test
    public void testSortList() throws Exception {
        ListNode head = test.generateList(param);
        Assert.assertArrayEquals(res, test.listToArray(test.sortList(head)));
    }

    /**
     * Method: sortListTLE(ListNode head)
     */
    @Test
    public void testSortListTLE() throws Exception {
        ListNode head = test.generateList(param);
        Assert.assertArrayEquals(res, test.listToArray(test.sortListTLE(head)));
    }
}
