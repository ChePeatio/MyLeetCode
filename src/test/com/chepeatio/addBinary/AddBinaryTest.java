package test.com.chepeatio.addBinary;

import com.chepeatio.addBinary.AddBinary;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * AddBinary Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ÎåÔÂ 26, 2016</pre>
 */
@RunWith(Parameterized.class)
public class AddBinaryTest {

    AddBinary test = new AddBinary();
    String param1;
    String param2;
    String res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"110011", "11000", "1001011"}
        });
    }

    public AddBinaryTest(String parameter1, String parameter2, String result) {
        param1 = parameter1;
        param2 = parameter2;
        res = result;
    }

    /**
     * Method: addBinary(String a, String b)
     */
    @Test
    public void testAddBinary() throws Exception {
         Assert.assertEquals(res, test.addBinary(param1, param2));
    }
} 
