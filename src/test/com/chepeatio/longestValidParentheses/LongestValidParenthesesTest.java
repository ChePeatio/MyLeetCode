package test.com.chepeatio.longestValidParentheses;

import com.chepeatio.longestValidParentheses.LongestValidParentheses;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * LongestValidParentheses Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ÎåÔÂ 6, 2016</pre>
 */
@RunWith(Parameterized.class)
public class LongestValidParenthesesTest {

    LongestValidParentheses test = new LongestValidParentheses();
    String param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {")()()(", 4},
                {"(())()", 6},
                {"((())))()", 6},
                {"())()()", 4},
                {"()(()))", 6},
                {"(()", 2},
                {"(()(((()", 2}
        });
    }

    public LongestValidParenthesesTest(String parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: longestValidParentheses(String s)
     */
    @Test
    public void testLongestValidParentheses() throws Exception {
        Assert.assertEquals(res, test.longestValidParentheses(param));
    }
} 
