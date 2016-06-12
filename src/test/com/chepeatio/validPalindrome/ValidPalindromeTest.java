package test.com.chepeatio.validPalindrome;

import com.chepeatio.validPalindrome.ValidPalindrome;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * ValidPalindrome Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ÁùÔÂ 12, 2016</pre>
 */
@RunWith(Parameterized.class)
public class ValidPalindromeTest {

    private ValidPalindrome test = new ValidPalindrome();
    private String param;
    private boolean res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"A man, a plan, a canal: Panama", true},
                {"race a car", false},
                {"", true},
                {"p Op", true},
                {"abc", false}
        });
    }

    public ValidPalindromeTest(String parameter, boolean result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: isPalindrome(String s)
     */
    @Test
    public void testIsPalindrome() throws Exception {
        Assert.assertEquals(res, test.isPalindrome(param));
    }
} 
