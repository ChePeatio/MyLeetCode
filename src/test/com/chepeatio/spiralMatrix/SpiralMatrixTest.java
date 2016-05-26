package test.com.chepeatio.spiralMatrix;

import com.chepeatio.spiralMatrix.SpiralMatrix;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * SpiralMatrix Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ÎåÔÂ 24, 2016</pre>
 */
@RunWith(Parameterized.class)
public class SpiralMatrixTest {

    SpiralMatrix test = new SpiralMatrix();
    int[][] param;
    Integer[] res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{new int[]{1,2,3,4}, new int[]{5,6,7,8}, new int[]{9,10,11,12}},
                        new Integer[]{1,2,3,4,8,12,11,10,9,5,6,7}},
                {new int[][]{new int[]{1,2,3,4}, new int[]{5,6,7,8},
                        new int[]{9,10,11,12}, new int[]{13,14,15,16}},
                        new Integer[]{1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10}},
                {new int[][]{}, new Integer[]{}},
                {new int[][]{new int[]{1,2,3}}, new Integer[]{1,2,3}}
        });
    }

    public SpiralMatrixTest(int[][] parameter, Integer[] result) {
        param = parameter;
        res =result;
    }

    /**
     * Method: spiralOrder(int[][] matrix)
     */
    @Test
    public void testSpiralOrder() throws Exception {
        Assert.assertArrayEquals(res, test.spiralOrder(param).toArray(new Integer[res.length]));
    }
} 
