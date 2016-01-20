package test.com.chepeatio.lengthOfLastWord;

import com.chepeatio.lengthOfLastWord.LengthOfLastWord;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * LengthOfLastWord Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ò»ÔÂ 20, 2016</pre>
 */
@RunWith(Parameterized.class)
public class LengthOfLastWordTest {

    LengthOfLastWord test = new LengthOfLastWord();
    String param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"Hello World", 5},
                {"", 0},
                {" ", 0},
                {"a ", 1},
                {"AnD", 3}
        });
    }

    public LengthOfLastWordTest(String parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: lengthOfLastWord(String s)
     */
    @Test
    public void testLengthOfLastWord() throws Exception {
        Assert.assertEquals(res, test.lengthOfLastWord(param));
    }
} 
