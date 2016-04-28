package test.com.chepeatio.longestCommonPrefix;

import com.chepeatio.longestCommonPrefix.LongestCommonPrefix;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * LongestCommonPrefix Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ËÄÔÂ 27, 2016</pre>
 */
@RunWith(Parameterized.class)
public class LongestCommonPrefixTest {

    LongestCommonPrefix test = new LongestCommonPrefix();
    String[] param;
    String res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new String[]{"abc", "aaa", "abbbb"}, "a"},
                {new String[]{"skdjfowie", "fwoeifw"}, ""},
                {new String[]{"asdf"}, "asdf"},
                {new String[]{"aaaaaaaaaaa", "aaaaaaaaaaaaaaa"}, "aaaaaaaaaaa"},
                {new String[]{"asdf", "asdf", "asdfg", "asdfg"}, "asdf"}
        });
    }

    public LongestCommonPrefixTest(String[] parameter, String result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: longestCommonPrefix(String[] strs)
     */
    @Test
    public void testLongestCommonPrefix() throws Exception {
        Assert.assertEquals(res, test.longestCommonPrefix(param));
    }
} 
