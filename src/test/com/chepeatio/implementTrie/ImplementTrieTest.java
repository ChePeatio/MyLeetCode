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
public class ImplementTrieTest {

    Trie test = new Trie();
    String[] words;
    String word;
    boolean result;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new String[]{"something", "goodjob", "good"}, "good", true},
                {new String[]{}, "good", false},
                {new String[]{"something", "good"}, "goo", false}
        });
    }

    public ImplementTrieTest(String[] strArray, String w, boolean result) {
        this.words = strArray;
        this.word = w;
        this.result = result;
    }

    @Test
    public void TestTrieSearch() {
        for(String s : words)
            test.insert(s);
        assertEquals(result, test.search(word));
    }
}