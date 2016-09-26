package com.chepeatio.validParentheses;

import com.chepeatio.validParentheses.ValidParentheses;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * ValidParentheses Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>¶þÔÂ 23, 2016</pre>
 */
@RunWith(Parameterized.class)
public class ValidParenthesesTest {

    ValidParentheses test = new ValidParentheses();
    String param;
    boolean res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"(())(){[]}", true},
                {"((())[]{}", false},
                {"([{)]}", false},
                {"(", false},
                {"([])", true}
        });
    }

    public ValidParenthesesTest(String parameter, boolean result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: isValid(String s)
     */
    @Test
    public void testIsValid() throws Exception {
        Assert.assertEquals(res, test.isValid(param));
    }
} 
