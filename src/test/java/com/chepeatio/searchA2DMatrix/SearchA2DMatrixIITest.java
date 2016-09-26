package com.chepeatio.searchA2DMatrix;

import com.chepeatio.searchA2DMatrix.SearchA2DMatrixII;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * SearchA2DMatrixII Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®¶þÔÂ 26, 2015</pre>
 */
@RunWith(Parameterized.class)
public class SearchA2DMatrixIITest {

    SearchA2DMatrixII test = new SearchA2DMatrixII();
    int[][] param1;
    int param2;
    boolean res;

    static int[][] matrix = new int[][]{
            {1,4,7,11,15,31},
            {2,5,8,12,19,32},
            {3,6,9,16,22,33},
            {10,13,14,17,24,34},
            {18,21,23,26,30,36}
    };

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {matrix, 2, true},
                {matrix, 35, false},
                {matrix, 20, false},
                {matrix, 9, true},
                {new int[][]{{1,2,3,4,5,6,7,8,9,10,12,15,64,73,88,90,100,101}}, 75, false}
        });
    }

    public SearchA2DMatrixIITest(int[][] parameter1, int parameter2, boolean result) {
        param1 = parameter1;
        param2 = parameter2;
        res = result;
    }

    /**
     * Method: searchMatrix(int[][] matrix, int target)
     */
    @Test
    public void testSearchMatrix() throws Exception {
        Assert.assertEquals(res, test.searchMatrix(param1, param2));
    }
} 
