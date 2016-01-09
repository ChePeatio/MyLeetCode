package test.com.chepeatio.maximumProductOfWordLengths;

import com.chepeatio.maximumProductOfWordLengths.MaximumProductOfWordLengths;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * MaximumProductOfWordLengths Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ò»ÔÂ 9, 2016</pre>
 */
@RunWith(Parameterized.class)
public class MaximumProductOfWordLengthsTest {

    MaximumProductOfWordLengths test = new MaximumProductOfWordLengths();
    String[] param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}, 16},
                {new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}, 4},
                {new String[]{"a", "aa", "aaa", "aaaa"}, 0}
        });
    }

    public MaximumProductOfWordLengthsTest(String[] parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: maxProduct(String[] words)
     */
    @Test
    public void testMaxProduct() throws Exception {
         Assert.assertEquals(res, test.maxProduct(param));
    }
} 
