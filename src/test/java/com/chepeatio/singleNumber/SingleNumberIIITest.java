package com.chepeatio.singleNumber;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by CheKedar on 2015/10/20.
 */
@RunWith(Parameterized.class)
public class SingleNumberIIITest {

    private SingleNumberIII test = new SingleNumberIII();
    private int[] param;
    private int[] result;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3,4,1,3,4,5}, new int[]{2,5}},
                {new int[]{1,1,2,2,3,3,7,4}, new int[]{4,7}},
                {new int[]{3,4}, new int[]{3,4}}
        });
    }

    public SingleNumberIIITest(int[] param, int[] result) {
        this.param = param;
        this.result = result;
    }

    @Test
    public void TestSingleNumber() {
        int[] arr = test.singleNumber(param);
        Arrays.sort(arr);
        Assert.assertArrayEquals(result, arr);
    }

    @Test
    public void TestSingleNumberBS() {
        int[] arr = test.singleNumberBS(param);
        Arrays.sort(arr);
        Assert.assertArrayEquals(result, arr);
    }
}
