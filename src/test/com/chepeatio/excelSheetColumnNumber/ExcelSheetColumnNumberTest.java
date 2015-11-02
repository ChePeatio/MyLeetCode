package test.com.chepeatio.excelSheetColumnNumber;

import com.chepeatio.excelSheetColumnNumber.ExcelSheetColumnNumber;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * ExcelSheetColumnNumber Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>Ê®ÔÂ 30, 2015</pre>
 */
@RunWith(Parameterized.class)
public class ExcelSheetColumnNumberTest {

    ExcelSheetColumnNumber test = new ExcelSheetColumnNumber();
    String param;
    int res;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"A", 1},
                {"Y", 25},
                {"AA", 27},
                {"AB", 28}
        });
    }

    public ExcelSheetColumnNumberTest(String parameter, int result) {
        param = parameter;
        res = result;
    }

    /**
     * Method: titleToNumber(String s)
     */
    @Test
    public void testTitleToNumber() throws Exception {
        Assert.assertEquals(res, test.titleToNumber(param));
    }


} 
