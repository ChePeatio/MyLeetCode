package test.com.chepeatio.excelSheetColumnNumber;

import com.chepeatio.excelSheetColumnNumber.ExcelSheetColumnNumber;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * ExcelSheetColumnNumber Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>ʮ�� 30, 2015</pre>
 */
@RunWith(Parameterized.class)
public class ExcelSheetColumnNumberTest {

    private ExcelSheetColumnNumber test = new ExcelSheetColumnNumber();
    private String param;
    private int res;

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
