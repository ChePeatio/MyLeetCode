package com.chepeatio.rectangleArea;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/** 
* RectangleArea Tester. 
* 
* @author <Authors name> 
* @since <pre>Ê®ÔÂ 26, 2015</pre> 
* @version 1.0 
*/
@RunWith(Parameterized.class)
public class RectangleAreaTest { 

    private RectangleArea test = new RectangleArea();
    private int[] param;
    private int result;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{-3,0,3,4,0,-1,9,2}, 45}
        });
    }

    public RectangleAreaTest(int[] param, int result) {
        this.param = param;
        this.result = result;
    }

    /**
    *
    * Method: computeAreaBS(int A, int B, int C, int D, int E, int F, int G, int H)
    *
    */
    @Test
    public void testComputeAreaBS() throws Exception {
        Assert.assertEquals(result, test.computeAreaBS(param[0], param[1], param[2], param[3], param[4], param[5], param[6], param[7]));
    }
} 
