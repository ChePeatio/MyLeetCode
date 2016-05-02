package test.com.chepeatio.reverseNodesInKGroup;

import com.chepeatio.reverseNodesInKGroup.ReverseNodesInKGroup;
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
 * ReverseNodesInKGroup Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ÎåÔÂ 2, 2016</pre>
 */
@RunWith(Parameterized.class)
public class ReverseNodesInKGroupTest {

    ReverseNodesInKGroup test = new ReverseNodesInKGroup();
    int[] param1;
    int param2;
    int[] res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3,4,5}, 1, new int[]{1,2,3,4,5}},
                {new int[]{1,2,3,4,5}, 2, new int[]{2,1,4,3,5}},
                {new int[]{1,2,3,4,5}, 3, new int[]{3,2,1,4,5}}
        });
    }

    public ReverseNodesInKGroupTest(int[] parameter1, int parameter2, int[] result) {
        param1 = parameter1;
        param2 = parameter2;
        res = result;
    }

    /**
     * Method: reverseKGroup(ListNode head, int k)
     */
    @Test
    public void testReverseKGroup() throws Exception {
        ListNode head = ListNode.generateList(param1);
        ListNode lns = test.reverseKGroup(head, param2);
        ListNode r = ListNode.generateList(res);
        Assert.assertEquals(true, ListNode.compareTwoLists(lns, r));
    }
} 
