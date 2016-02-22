package test.com.chepeatio.longestIncreasingPathInAMatrix;

import com.chepeatio.longestIncreasingPathInAMatrix.LongestIncreasingPathInAMatrix;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * LongestIncreasingPathInAMatrix Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>¶þÔÂ 22, 2016</pre>
 */
@RunWith(Parameterized.class)
public class LongestIncreasingPathInAMatrixTest {

    LongestIncreasingPathInAMatrix test = new LongestIncreasingPathInAMatrix();
    int[][] param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{{9,9,4},{6,6,8},{2,1,1}}, 4},
                {new int[][]{{3,4,5},{3,2,6},{2,2,1}}, 4}
        });
    }

    public LongestIncreasingPathInAMatrixTest(int[][] parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: longestIncreasingPath(int[][] matrix)
     */
    @Test
    public void testLongestIncreasingPath() throws Exception {
         Assert.assertEquals(res, test.longestIncreasingPath(param));
    }
} 
