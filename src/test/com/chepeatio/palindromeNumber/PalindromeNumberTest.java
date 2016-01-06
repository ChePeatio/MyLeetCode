package test.com.chepeatio.palindromeNumber;

import com.chepeatio.palindromeNumber.PalindromeNumber;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * PalindromeNumber Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ò»ÔÂ 6, 2016</pre>
 */
@RunWith(Parameterized.class)
public class PalindromeNumberTest {

    PalindromeNumber test = new PalindromeNumber();
    int param;
    boolean res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {38, false},
                {6366, false},
                {868, true},
                {9, true},
                {111, true}
        });
    }

    public PalindromeNumberTest(int parameter, boolean result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: isPalindrome(int x)
     */
    @Test
    public void testIsPalindrome() throws Exception {
        Assert.assertEquals(res, test.isPalindrome(param));
    }
} 
