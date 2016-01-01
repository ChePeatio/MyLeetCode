package test.com.chepeatio.pascalTriangle;

import com.chepeatio.pascalTriangle.PascalTriangleII;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * PascalTriangleII Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ò»ÔÂ 1, 2016</pre>
 */
@RunWith(Parameterized.class)
public class PascalTriangleIITest {

    PascalTriangleII test = new PascalTriangleII();
    int param;
    List<Integer> res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {0, new ArrayList<Integer>(){{add(1);}}},
                {1, new ArrayList<Integer>(){{add(1);add(1);}}},
                {3, new ArrayList<Integer>(){{add(1);add(3);add(3);add(1);}}}
        });
    }

    public PascalTriangleIITest(int parameter, List<Integer> result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: getRow(int rowIndex)
     */
    @Test
    public void testGetRow() throws Exception {
        Assert.assertEquals(res, test.getRow(param));
    }
} 
