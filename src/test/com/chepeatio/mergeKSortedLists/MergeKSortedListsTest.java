package test.com.chepeatio.mergeKSortedLists;

import com.chepeatio.mergeKSortedLists.MergeKSortedLists;
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
 * MergeKSortedLists Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ÎåÔÂ 1, 2016</pre>
 */
@RunWith(Parameterized.class)
public class MergeKSortedListsTest {

    MergeKSortedLists test = new MergeKSortedLists();
    int[][] param;
    int[] res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{new int[]{}, new int[]{}}, new int[]{}},
                {new int[][]{new int[]{1,2,3,4,5}}, new int[]{1,2,3,4,5}},
                {new int[][]{new int[]{1,3,5,7,9}, new int[]{2,4,6,8}}, new int[]{1,2,3,4,5,6,7,8,9}},
                {new int[][]{new int[]{1,4,7}, new int[]{2,5,8}, new int[]{3,6,9}}, new int[]{1,2,3,4,5,6,7,8,9}},
                {new int[][]{new int[]{-2,-1,-1,-1}, new int[]{}}, new int[]{-2,-1,-1,-1}}
        });
    }

    public MergeKSortedListsTest(int[][] parameter, int[] result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: mergeKLists(ListNode[] lists)
     */
    @Test
    public void testMergeKLists() throws Exception {
        ListNode[] lns = new ListNode[param.length];
        for (int i=0; i<param.length; i++) {
            lns[i] = ListNode.generateList(param[i]);
        }
        ListNode ln = ListNode.generateList(res);
        Assert.assertEquals(true, ListNode.compareTwoLists(ln, test.mergeKLists(lns)));
    }
} 
