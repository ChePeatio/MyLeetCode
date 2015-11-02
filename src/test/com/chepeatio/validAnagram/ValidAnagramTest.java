package test.com.chepeatio.validAnagram;

import com.chepeatio.validAnagram.ValidAnagram;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * ValidAnagram Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®ÔÂ 31, 2015</pre>
 */
@RunWith(Parameterized.class)
public class ValidAnagramTest {

    ValidAnagram test = new ValidAnagram();
    String[] param;
    boolean res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new String[]{"xiasiwole", "megaodong"}, false},
                {new String[]{"spark", "parsk"}, true},
                {new String[]{"", ""}, true},
                {new String[]{"abcd", "dbcaa"}, false},
                {new String[]{"aabbcc", "bbbbbb"}, false}
        });
    }

    public ValidAnagramTest(String[] parameter, boolean result) {
        param = parameter;
        res = result;
    }
    /**
     * Method: isAnagram(String s, String t)
     */
    @Test
    public void testIsAnagram() throws Exception {
        Assert.assertEquals(res, test.isAnagram(param[0], param[1]));
    }

    /**
     * Method: isAnagramBS(String s, String t)
     */
    @Test
    public void testIsAnagramBS() throws Exception {
        Assert.assertEquals(res, test.isAnagramBS(param[0], param[1]));
    }
} 
