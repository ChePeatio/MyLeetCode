package test.com.chepeatio.letterCombinationsOfaPhoneNumber;

import com.chepeatio.letterCombinationsOfaPhoneNumber.LetterCombinationsOfaPhoneNumber;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * LetterCombinationsOfaPhoneNumber Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ËÄÔÂ 30, 2016</pre>
 */
@RunWith(Parameterized.class)
public class LetterCombinationsOfaPhoneNumberTest {

    LetterCombinationsOfaPhoneNumber test = new LetterCombinationsOfaPhoneNumber();
    String param;
    String[] res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"23", new String[]{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"}},
                {"2", new String[]{"a","b","c"}}
        });
    }

    public LetterCombinationsOfaPhoneNumberTest(String parameter, String[] result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: letterCombinations(String digits)
     */
    @Test
    public void testLetterCombinations() throws Exception {
        List<String> testResult = test.letterCombinations(param);
        for (int i=0; i<testResult.size(); i++) {
            Assert.assertEquals(res[i], testResult.get(i));
        }
    }
} 
