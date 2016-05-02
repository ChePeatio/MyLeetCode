package test.com.chepeatio.implement_strStr;

import com.chepeatio.implement_strStr.Implement_strStr;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Implement_strStr Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ÎåÔÂ 1, 2016</pre>
 */
@RunWith(Parameterized.class)
public class Implement_strStrTest {

    Implement_strStr test = new Implement_strStr();
    String param1;
    String param2;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"abcdefg", "cde", 2},
                {"asdfasdf", "sd", 1},
                {"aaaaaa", "b", -1}
        });
    }

    public Implement_strStrTest(String parameter1, String parameter2, int result) {
        param1 = parameter1;
        param2 = parameter2;
        res = result;
    }

    /**
     * Method: strStr(String haystack, String needle)
     */
    @Test
    public void testStrStr() throws Exception {
        Assert.assertEquals(res, test.strStr(param1, param2));
    }
} 
