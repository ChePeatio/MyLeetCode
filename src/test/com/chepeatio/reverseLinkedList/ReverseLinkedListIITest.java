package test.com.chepeatio.reverseLinkedList;

import com.chepeatio.reverseLinkedList.ReverseLinkedListII;
import com.chepeatio.utils.ListNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * ReverseLinkedListII Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ÁùÔÂ 13, 2016</pre>
 */
@RunWith(Parameterized.class)
public class ReverseLinkedListIITest {

    private ReverseLinkedListII test = new ReverseLinkedListII();
    private int[] param1;
    private int param2;
    private int param3;
    private int[] res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3,4,5}, 2, 4, new int[]{1,4,3,2,5}},
                {new int[]{1,2}, 1, 2, new int[]{2,1}},
                {new int[]{1}, 1,1, new int[]{1}},
                {new int[]{1,2,3,4,5,6,7,8,9}, 1, 9, new int[]{9,8,7,6,5,4,3,2,1}}
        });
    }

    public ReverseLinkedListIITest(int[] parameter1, int parameter2, int parameter3, int[] result) {
        param1 = parameter1;
        param2 = parameter2;
        param3 = parameter3;
        res = result;
    }

    /**
     * Method: reverseBetween(ListNode head, int m, int n)
     */
    @Test
    public void testReverseBetween() throws Exception {
         Assert.assertEquals(true,
                 ListNode.compareTwoLists(ListNode.generateList(res),
                         test.reverseBetween(ListNode.generateList(param1), param2, param3)));
    }
} 
