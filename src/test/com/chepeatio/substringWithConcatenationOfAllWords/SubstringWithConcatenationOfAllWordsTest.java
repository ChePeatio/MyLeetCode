package test.com.chepeatio.substringWithConcatenationOfAllWords;

import com.chepeatio.substringWithConcatenationOfAllWords.SubstringWithConcatenationOfAllWords;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * SubstringWithConcatenationOfAllWords Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ÎåÔÂ 3, 2016</pre>
 */
@RunWith(Parameterized.class)
public class SubstringWithConcatenationOfAllWordsTest {

    SubstringWithConcatenationOfAllWords test = new SubstringWithConcatenationOfAllWords();
    String param1;
    String[] param2;
    int[] res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"barfoothefoobarman", new String[]{"foo", "bar"}, new int[]{0,9}},
                {"barfoofoobarthefoobarman", new String[]{"bar","foo","the"}, new int[]{6,9,12}},
                {"wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}, new int[]{8}},
                {"aaaaaaaa", new String[]{"aa","aa","aa"}, new int[]{0,1,2}}
        });
    }

    public SubstringWithConcatenationOfAllWordsTest(String parameter1, String[] parameter2, int[] result) {
        param1 = parameter1;
        param2 = parameter2;
        res = result;
    }

    /**
     * Method: findSubstring(String s, String[] words)
     */
    @Test
    public void testFindSubstring() throws Exception {
        List<Integer> list = test.findSubstring(param1, param2);
        Assert.assertEquals(list.size(), res.length);
        Collections.sort(list);
        for (int i=0; i<res.length; i++) {
            Assert.assertEquals(list.get(i), Integer.valueOf(res[i]));
        }
    }
} 
