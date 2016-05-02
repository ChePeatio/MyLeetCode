package test.com.chepeatio.partitionList;

import com.chepeatio.utils.ListNode;
import com.chepeatio.partitionList.PartitionList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Che Peatio on 2015/10/19.
 * Edited by Che Peatio on 2016/05/02.
 */
@RunWith(Parameterized.class)
public class PartitionListTest {

    PartitionList part = new PartitionList();
    int[] param;
    int flag;
    String result;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{4,1,3,2,5,2}, 3, "122435"},
                {new int[]{3,1,4,5,2,6}, 4, "312456"}
        });
    }

    // 构造函数，对变量进行初始化
    public PartitionListTest(int[] param, int flag, String result) {
        this.param = param;
        this.flag = flag;
        this.result = result;
    }

    @Test
    public void Test1PartitionList() {
        ListNode head = ListNode.generateList(param);
        head = part.PartitionNS(head, flag);
        assertEquals(result, head.getValList());
    }
}
