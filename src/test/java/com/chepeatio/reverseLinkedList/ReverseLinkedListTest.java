package com.chepeatio.reverseLinkedList;

import com.chepeatio.utils.ListNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * ReverseLinkedList Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>Ê®Ò»ÔÂ 1, 2015</pre>
 */
@RunWith(Parameterized.class)
public class ReverseLinkedListTest {

    private ReverseLinkedList test = new ReverseLinkedList();
    private int[] param;
    private int[] res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 4}, new int[]{4, 3, 2, 1}},
                {new int[]{2, 3, 4, 5}, new int[]{5, 4, 3, 2}},
                {new int[]{2, -3, 4, -5}, new int[]{-5, 4, -3, 2}},
                {new int[]{5}, new int[]{5}},
                {new int[]{}, new int[]{}}
        });
    }

    public ReverseLinkedListTest(int[] parameter, int[] result) {
        param = parameter;
        res = result;
    }
    
    /**
     * Method: reverseList(ListNode head)
     */
    @Test
    public void testReverseList() throws Exception {
        Assert.assertEquals(true, ListNode.compareTwoLists(ListNode.generateList(res),
                test.reverseList(ListNode.generateList(param))));
    }
}
