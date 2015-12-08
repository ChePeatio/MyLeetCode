package test.com.chepeatio.containerWithMostWater; 

import com.chepeatio.containerWithMostWater.ContainerWithMostWater;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/** 
* ContainerWithMostWater Tester. 
* 
* @author <Authors name> 
* @since <pre>Ê®¶þÔÂ 8, 2015</pre> 
* @version 1.0 
*/
@RunWith(Parameterized.class)
public class ContainerWithMostWaterTest { 

    ContainerWithMostWater test = new ContainerWithMostWater();
    int[] param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3,4}, 4},
                {new int[]{3,3,3,3}, 9},
                {new int[]{1,1}, 1}
        });
    }

    public ContainerWithMostWaterTest(int[] parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: maxArea(int[] height)
     */
    @Test
    public void testMaxArea() throws Exception {
        Assert.assertEquals(res, test.maxArea(param));
    }
} 
