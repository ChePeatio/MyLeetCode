package test.com.chepeatio.pascalTriangle; 

import com.chepeatio.pascalTriangle.PascalTriangle;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/** 
* PascalTriangle Tester. 
* 
* @author <Authors name> 
* @since <pre>Ê®ÔÂ 28, 2015</pre> 
* @version 1.0 
*/
@RunWith(Parameterized.class)
public class PascalTriangleTest { 
    PascalTriangle test = new PascalTriangle();
    int param;
    int[] res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {5, new int[]{1, 1, 1, 1, 2, 1, 1, 3, 3, 1, 1, 4, 6, 4, 1}},
                {1, new int[]{1}},
                {0, new int[]{}}
        });
    }

    public PascalTriangleTest(int parameter, int[] result) {
        param = parameter;
        res = result;
    }

    /**
    *
    * Method: generate(int numRows)
    *
    */
    @Test
    public void testGenerate() throws Exception {
        //TODO: Test goes here...
        ArrayList<Integer> al = new ArrayList<>();
        List<List<Integer>> lli = test.generate(param);
        for (int i=0; i<lli.size(); i++) {
            al.addAll(lli.get(i));
        }
        int[] ala = new int[al.size()];
        for (int i=0; i<ala.length; i++) {
            ala[i] = al.get(i);
        }
        Assert.assertArrayEquals(res, ala);
    }
} 
