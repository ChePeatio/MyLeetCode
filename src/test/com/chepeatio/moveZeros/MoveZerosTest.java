package test.com.chepeatio.moveZeros; 

import com.chepeatio.moveZeros.MoveZeros;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

/** 
* MoveZeros Tester. 
* 
* @author <Authors name> 
* @since <pre>Ê®ÔÂ 27, 2015</pre> 
* @version 1.0 
*/
@RunWith(Parameterized.class)
public class MoveZerosTest {

    MoveZeros test = new MoveZeros();
    int[] param;
    int[] res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0}},
                {new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0}}
        });
    }

    public MoveZerosTest(int[] parameters, int[] results) {
        param = parameters;
        res = results;
    }

    /**
    *
    * Method: moveZeroes(int[] nums)
    *
    */
    @Test
    public void testMoveZeroes() throws Exception {
        //TODO: Test goes here...
        test.moveZeroes(param);
        assertArrayEquals(res, param);
    }

    /**
    *
    * Method: moveZeroesBS(int[] nums)
    *
    */
    @Ignore
    @Test
    public void testMoveZeroesBS() throws Exception {
        //TODO: Test goes here...
        test.moveZeroesBS(param);
        assertArrayEquals(res, param);
    }
} 
