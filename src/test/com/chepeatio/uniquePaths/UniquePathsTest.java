package test.com.chepeatio.uniquePaths;

import com.chepeatio.uniquePaths.UniquePaths;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * UniquePaths Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®Ò»ÔÂ 20, 2015</pre>
 */
@RunWith(Parameterized.class)
public class UniquePathsTest {

    UniquePaths test = new UniquePaths();
    int m, n;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {3, 4, 10},
                {2, 1, 1},
                {4, 4, 20}
        });
    }

    public UniquePathsTest(int pm, int pn, int result) {
        m = pm;
        n = pn;
        res = result;
    }

    /**
     * Method: uniquePaths(int m, int n)
     */
    @Test
    public void testUniquePaths() throws Exception {
        Assert.assertEquals(res, test.uniquePaths(m, n));
    }

    /**
     * Method: uniquePathsTLE(int m, int n)
     */
    @Ignore
    @Test
    public void testUniquePathsTLE() throws Exception {
        Assert.assertEquals(res, test.uniquePathsBS(m, n));
    }
} 
