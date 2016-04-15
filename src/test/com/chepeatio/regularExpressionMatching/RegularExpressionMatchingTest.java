package test.com.chepeatio.regularExpressionMatching;

import com.chepeatio.regularExpressionMatching.RegularExpressionMatching;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * RegularExpressionMatching Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ËÄÔÂ 15, 2016</pre>
 */
@RunWith(Parameterized.class)
public class RegularExpressionMatchingTest {

    RegularExpressionMatching test = new RegularExpressionMatching();
    String param1;
    String param2;
    boolean res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"aa", "a", false},
                {"aa", "aa", true},
                {"aaa", "aa", false},
                {"aa", "a*", true},
                {"aa", ".*", true},
                {"ab", ".*", true},
                {"aab", "c*a*b", true},
                {"ab", ".*c", false}
        });
    }

    public RegularExpressionMatchingTest(String p1, String p2, boolean r) {
        param1 = p1;
        param2 = p2;
        res = r;
    }

    /**
     * Method: isMatch(String s, String p)
     */
    @Test
    public void testIsMatch() throws Exception {
        Assert.assertEquals(res, test.isMatch(param1, param2));
    }
} 
