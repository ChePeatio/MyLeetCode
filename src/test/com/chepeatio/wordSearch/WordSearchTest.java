package test.com.chepeatio.wordSearch;

import com.chepeatio.wordSearch.WordSearch;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * WordSearch Tester.
 *
 * @author Kedar Che
 * @version 1.0
 * @since <pre>°ËÔÂ 8, 2016</pre>
 */
@RunWith(Parameterized.class)
public class WordSearchTest {

    private WordSearch test = new WordSearch();
    private char[][] board;
    private String word;
    private boolean result;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new char[][]{{'a', 'b', 'c', 'e'},
                        {'s', 'f', 'c', 's'},
                        {'a', 'd', 'e', 'e'}}, "abcced", true},
                {new char[][]{{'a', 'b', 'c', 'e'},
                        {'s', 'f', 'c', 's'},
                        {'a', 'd', 'e', 'e'}}, "see", true},
                {new char[][]{{'a', 'b', 'c', 'e'},
                        {'s', 'f', 'c', 's'},
                        {'a', 'd', 'e', 'e'}}, "abcb", false},
                {new char[][]{{'c', 'a', 'a'},
                        {'a', 'a', 'a'},
                        {'b', 'c', 'd'}}, "aab", true}
        });
    }

    public WordSearchTest(char[][] board, String word, boolean result) {
        this.board = board;
        this.word = word;
        this.result = result;
    }

    /**
     * Method: exist(char[][] board, String word)
     */
    @Test
    public void testExist() throws Exception {
        Assert.assertEquals(result, test.exist(board, word));
    }
} 
