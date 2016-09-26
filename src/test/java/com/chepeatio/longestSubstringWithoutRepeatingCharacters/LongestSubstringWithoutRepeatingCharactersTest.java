package com.chepeatio.longestSubstringWithoutRepeatingCharacters;

import com.chepeatio.longestSubstringWithoutRepeatingCharacters.LongestSubstringWithoutRepeatingCharacters;
import junit.framework.Assert;
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
 * @since <pre>Ê®Ò»ÔÂ 9, 2015</pre>
 */
@RunWith(Parameterized.class)
public class LongestSubstringWithoutRepeatingCharactersTest {

    LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
    String param;
    int res;

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
