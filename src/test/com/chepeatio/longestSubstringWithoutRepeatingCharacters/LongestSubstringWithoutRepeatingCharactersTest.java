package test.com.chepeatio.longestSubstringWithoutRepeatingCharacters;

import com.chepeatio.longestSubstringWithoutRepeatingCharacters.LongestSubstringWithoutRepeatingCharacters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * LongestSubstringWithoutRepeatingCharacters Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ʮһ�� 9, 2015</pre>
 */
@RunWith(Parameterized.class)
public class LongestSubstringWithoutRepeatingCharactersTest {

    private LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
    private String param;
    private int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"abcabcbb", 3},
                {"bbbbb", 1},
                {"c", 1}
        });
    }

    public LongestSubstringWithoutRepeatingCharactersTest(String parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: lengthOfLongestSubstring(String s)
     */
    @Test
    public void testLengthOfLongestSubstring() throws Exception {
        Assert.assertEquals(res, test.lengthOfLongestSubstring(param));
    }

    /**
     * Method: lengthOfLongestSubstringBS(String s)
     */
    @Test
    public void testLengthOfLongestSubstringBS() throws Exception {
        Assert.assertEquals(res, test.lengthOfLongestSubstringBS(param));
    }
} 
