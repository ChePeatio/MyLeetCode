package test.com.chepeatio.jumpGame;

import com.chepeatio.jumpGame.JumpGame;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * JumpGame Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ÎåÔÂ 23, 2016</pre>
 */
@RunWith(Parameterized.class)
public class JumpGameTest {

    JumpGame test = new JumpGame();
    int[] param;
    boolean res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{2, 3, 1, 1, 4}, true},
                {new int[]{3, 2, 1, 0, 4}, false}
        });
    }

    public JumpGameTest(int[] parameter, boolean result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: canJump(int[] nums)
     */
    @Test
    public void testCanJump() throws Exception {
        Assert.assertEquals(res, test.canJumpFlag(param));
    }
} 
