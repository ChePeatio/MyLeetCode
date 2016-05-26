package test.com.chepeatio.rotateList;

import com.chepeatio.rotateList.RotateList;
import com.chepeatio.utils.ListNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * RotateList Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ÎåÔÂ 26, 2016</pre>
 */
@RunWith(Parameterized.class)
public class RotateListTest {

    RotateList test = new RotateList();
    int[] param1;
    int param2;
    int[] res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 4, 5}, 2, new int[]{4, 5, 1, 2, 3}},
                {new int[]{}, 7, new int[]{}},
                {new int[]{1, 2, 3}, 3, new int[]{1, 2, 3}},
                {new int[]{1, 2}, 3, new int[]{2, 1}}
        });
    }

    public RotateListTest(int[] parameter1, int parameter2, int[] result) {
        param1 = parameter1;
        param2 = parameter2;
        res = result;
    }

    /**
     * Method: rotateRight(ListNode head, int k)
     */
    @Test
    public void testRotateRight() throws Exception {
         Assert.assertEquals(true, ListNode.compareTwoLists(ListNode.generateList(res),
                 test.rotateRight(ListNode.generateList(param1), param2)));
    }
} 
