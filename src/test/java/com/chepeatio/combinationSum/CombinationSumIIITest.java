package com.chepeatio.combinationSum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * CombinationSumIII Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®¶þÔÂ 17, 2015</pre>
 */
@RunWith(Parameterized.class)
public class CombinationSumIIITest {

    CombinationSumIII test = new CombinationSumIII();
    int paramK;
    int paramN;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {2, 7},
                {3, 7},
                {3, 9}
        });
    }

    public CombinationSumIIITest(int parameterK, int parameterN) {
        paramK = parameterK;
        paramN = parameterN;
    }

    /**
     * Method: combinationSum3(int k, int n)
     */
    @Test
    public void testCombinationSum3() throws Exception {
        List<List<Integer>> lli = test.combinationSum3(paramK, paramN);
        for (List<Integer> li : lli) {
            for (int i : li)
                System.out.print(i + " ");
            System.out.println("_____________");
        }
    }
} 
