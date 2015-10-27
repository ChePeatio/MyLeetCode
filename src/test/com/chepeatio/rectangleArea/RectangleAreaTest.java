package test.com.chepeatio.rectangleArea;

import com.chepeatio.rectangleArea.RectangleArea;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/** 
* RectangleArea Tester. 
* 
* @author <Authors name> 
* @since <pre>Ê®ÔÂ 26, 2015</pre> 
* @version 1.0 
*/
@RunWith(Parameterized.class)
public class RectangleAreaTest { 

    RectangleArea test = new RectangleArea();
    int[] param;
    int result;

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
        //TODO: Test goes here...
        assertEquals(result, test.computeAreaBS(param[0], param[1], param[2], param[3], param[4], param[5], param[6], param[7]));
    }
} 
