import com.chepeatio.partitionList.ListNode;
import com.chepeatio.partitionList.PartitionList;
import com.chepeatio.partitionList.UtilFunctions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by CheKedar on 2015/10/19.
 */
@RunWith(Parameterized.class)
public class PartitionTest {

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
    public PartitionTest(int[] param, int flag, String result) {
        this.param = param;
        this.flag = flag;
        this.result = result;
    }

    @Test
    public void Test1PartitionList() {
        ListNode head = UtilFunctions.generateListNode(param);
        head = part.PartitionNS(head, flag);
        assertEquals(result, head.getValList());
    }
}
