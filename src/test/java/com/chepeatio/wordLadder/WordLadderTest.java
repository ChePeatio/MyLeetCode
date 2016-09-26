package com.chepeatio.wordLadder;

import com.chepeatio.wordLadder.WordLadder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/** 
* WordLadder Tester. 
* 
* @author <Authors name> 
* @since <pre>Ê®Ò»ÔÂ 12, 2015</pre> 
* @version 1.0 
*/
@RunWith(Parameterized.class)
public class WordLadderTest {

    WordLadder test = new WordLadder();
    String beginWord, endWord;
    Set<String> wordList;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"hit", "cog", new HashSet<String>() {{
                    add("hot");
                    add("dot");
                    add("dog");
                    add("lot");
                    add("log");
                }}, 5}
        });
    }

    public WordLadderTest(String bw, String ew, Set<String> wl, int result) {
        beginWord = bw;
        endWord = ew;
        wordList = wl;
        res = result;
    }

    /**
     * Method: ladderLength(String beginWord, String endWord, Set<String> wordList)
     */
    @Test
    public void testLadderLength() throws Exception {
        Assert.assertEquals(res, test.ladderLength(beginWord, endWord, wordList));
    }
}
