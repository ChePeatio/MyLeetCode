package test.com.chepeatio.validSudoku;

import com.chepeatio.validSudoku.ValidSudoku;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * ValidSudoku Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Ò»ÔÂ 19, 2016</pre>
 */
@RunWith(Parameterized.class)
public class ValidSudokuTest {

    ValidSudoku test = new ValidSudoku();
    char[][] param;
    boolean res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new char[][]{
                        {'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'},
                }, true},
                {new char[][]{
                        {'5','3','.','.','7','4','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','8','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'},
                }, false}
        });
    }

    public ValidSudokuTest(char[][] parameter, boolean result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: isValidSudoku(char[][] board)
     */
    @Test
    public void testIsValidSudoku() throws Exception {
        Assert.assertEquals(res, test.isValidSudoku(param));
    }
} 
