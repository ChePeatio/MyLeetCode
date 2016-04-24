package test.com.chepeatio.longestPalindromicSubstring;

import com.chepeatio.longestPalindromicSubstring.LongestPalindromicSubstring;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * LongestPalindromicSubstring Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ËÄÔÂ 23, 2016</pre>
 */
@RunWith(Parameterized.class)
public class LongestPalindromicSubstringTest {

    LongestPalindromicSubstring test = new LongestPalindromicSubstring();
    String param;
    String res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"a", "a"},
                {"abba", "abba"},
                {"aba", "aba"},
                {"abbacc", "abba"},
                {"aabcacb", "bcacb"}
        });
    }

    public LongestPalindromicSubstringTest(String parameter, String result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: longestPalindrome(String s)
     */
    @Test
    public void testLongestPalindrome() throws Exception {
        Assert.assertEquals(res, test.longestPalindromeWithManacher(param));
    }
} 
