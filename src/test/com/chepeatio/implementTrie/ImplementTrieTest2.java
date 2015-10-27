package test.com.chepeatio.implementTrie;

import com.chepeatio.implementTrie.Trie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Che Peatio on 2015/10/26.
 */
@RunWith(Parameterized.class)
public class ImplementTrieTest2 {

    Trie test = new Trie();
    String[] words;
    String word;
    boolean result;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new String[]{"something", "goodjob", "good"}, "good", true},
                {new String[]{}, "good", false},
                {new String[]{"something", "good"}, "goo", true}
        });
    }

    public ImplementTrieTest2(String[] strArray, String w, boolean result) {
        this.words = strArray;
        this.word = w;
        this.result = result;
    }

    @Test
    public void TestTrie() {
        for (String s : words)
            test.insert(s);
        assertEquals(result, test.startsWith(word));
    }
}