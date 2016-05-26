package test.com.chepeatio.permutationSequence;

import com.chepeatio.permutationSequence.PermutationSequence;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * PermutationSequence Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ÎåÔÂ 26, 2016</pre>
 */
@RunWith(Parameterized.class)
public class PermutationSequenceTest {

    PermutationSequence test = new PermutationSequence();
    int param1;
    int param2;
    String res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {4, 19, "4123"},
                {3, 5, "312"},
                {3, 4, "231"},
                {1, 1, "1"},
                {1, 5, ""}
        });
    }

    public PermutationSequenceTest(int parameter1, int parameter2, String result) {
        param1 = parameter1;
        param2 = parameter2;
        res = result;
    }

    /**
     * Method: getPermutation(int n, int k)
     */
    @Test
    public void testGetPermutation() throws Exception {
         Assert.assertEquals(res, test.getPermutation(param1, param2));
    }
} 
