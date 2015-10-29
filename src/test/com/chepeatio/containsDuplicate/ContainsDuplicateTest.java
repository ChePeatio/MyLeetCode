package test.com.chepeatio.containsDuplicate; 

import com.chepeatio.containsDuplicate.ContainsDuplicate;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/** 
* ContainsDuplicate Tester. 
* 
* @author Che Peatio
* @since <pre>Ê®ÔÂ 29, 2015</pre> 
* @version 1.0 
*/
@RunWith(Parameterized.class)
public class ContainsDuplicateTest { 

    ContainsDuplicate test = new ContainsDuplicate();
    int[] param;
    boolean res;

    public ContainsDuplicateTest(int[] parameter, boolean result) {
        param = parameter;
        res = result;
    }

    public static int[] prepareData(int target, int dup) {
        int[] val = new int[target+dup];
        int i;
        for (i=0; i<target; i++) {
            val[i] = i;
        }
        for (;i<target+dup; i++) {
            val[i] = 0;
        }
        return val;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{0,1,2,3,4,5,5}, true},
                {new int[]{0}, false},
                {prepareData(20000, 0), false},
                {prepareData(20000, 1), true}
        });
    }
    /**
     *
     * Method: containsDuplicate(int[] nums)
     *
    */
        @Test
    public void testContainsDuplicate() throws Exception {
        Assert.assertEquals(res, test.containsDuplicate(param));
    }


} 
