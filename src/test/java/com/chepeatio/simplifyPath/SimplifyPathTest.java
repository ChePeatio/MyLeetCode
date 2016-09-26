package com.chepeatio.simplifyPath;

import com.chepeatio.simplifyPath.SimplifyPath;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * SimplifyPath Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ê®Ò»ÔÂ 13, 2015</pre>
 */
@RunWith(Parameterized.class)
public class SimplifyPathTest {

    SimplifyPath test = new SimplifyPath();
    String param;
    String res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"/home/", "/home"},
                {"/a/./b/../../c/", "/c"},
                {"/../", "/"},
                {"/home//foo/", "/home/foo"}
        });
    }

    public SimplifyPathTest(String parameter, String result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: simplifyPath(String path)
     */
    @Test
    public void testSimplifyPath() throws Exception {
        Assert.assertEquals(res, test.simplifyPath(param));
    }
} 
