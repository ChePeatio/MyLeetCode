package test.com.chepeatio.addDigits;

import com.chepeatio.addDigits.AddDigits;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * ContainsDuplicateII Tester.
 *
 * @author Che Peatio
 * @version 1.0
 * @since <pre>һ�� 12, 2016</pre>
 */
@RunWith(Parameterized.class)
public class AddDigitsTest {

    private AddDigits test = new AddDigits();
    private int param;
    private int result;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {38, 2},
                {1366, 7},
                {768, 3},
                {9, 9},
                {18, 9}
        });
    }

    // ���캯�����Ա������г�ʼ��
    public AddDigitsTest(int param, int result) {
        this.param = param;
        this.result = result;
    }

    @Test
    public void TestAddDigits() {
        assertEquals(result, test.addDigits(param));
    }

    @Test
    public void TestAddDigitsBS() {
        assertEquals(result, test.addDigitsBS(param));
    }
}
