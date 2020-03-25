package testpackage;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author orestis
 */
public class CalculatorTest {
    private Calculator calc;
    
    public CalculatorTest() {
    }
    
    @Before
    public void setUp() {
         calc = new Calculator();
    }

    @Test
    public void testGetSumValid() {
        Calculator calc = new Calculator();
        int result = calc.getSum(2, 5);
        assertEquals(7, result);
    }
    
    @Test
    public void testGetSumNotValid() {
        Calculator calc = new Calculator();
        int result = calc.getSum(2, 5);
        assertNotEquals(8, result);
    }
    
    @Test
    public void testGetRemainderValid() {
        double result = calc.getRemainder(8, 2);
        assertEquals(4, result, 0.00001);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testGetRemainderZero() {
        calc.getRemainder(8, 0);
    }
    
    @Test
    public void testGetRemainderNegative() {
        double result = calc.getRemainder(8, -2);
        assertTrue(result < 0);
    }
    
    @Test
    public void testGetRemainderPositive() {
        double result = calc.getRemainder(8, 2);
        assertFalse(result < 0);
    }
    
    @Test
    public void testGetRemainderNotValid() {
        double result = calc.getRemainder(8, 2);
        assertNotEquals(5, result, 0.00001);
    }
    
    @Test
    public void testSumOfArrayValid() {
        int array[] = {2, 4, 8};
        int result = calc.sumOfArray(array);
        assertEquals(14, result);
    }
    
    @Test
    public void testSumOfArrayPositive() {
        int array[] = {2, 4, 8};
        int result = calc.sumOfArray(array);
        assertTrue(result > 0);
    }
    
    @Test
    public void testSumOfArrayNotValid() {
        int array[] = {5, 3, 2};
        int result = calc.sumOfArray(array);
        assertNotEquals(14, result);
    }
    
    @Test
    public void testMultiplyIntArrayItemsWith() {
        int[] array = {5, 3, 2};
        int number = 2;
        calc.multiplyIntArrayItemsWith(array, number);
        int[] resultArr = {10, 6, 4};
        for (int item: array){
            System.out.println(item);
        }
        assertArrayEquals(resultArr, array);
    }
}
