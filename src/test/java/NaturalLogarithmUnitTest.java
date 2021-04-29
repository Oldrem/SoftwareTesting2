import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class NaturalLogarithmUnitTest {
    private HashMap<Double, Double> arrayTestValues = new HashMap<>();
    private static final double tolerancy = 0.00001;
    private NaturalLogarithm ln = new NaturalLogarithm(tolerancy);

    private boolean checkTolerancy(double a, double b, double tolerancy){
        return (Math.abs(a-b) <= tolerancy);
    }

    @Before
    public void setUp() {
        // ключ - x, значение - введенное значение - y

        arrayTestValues.put( 0d, Double.NEGATIVE_INFINITY);
        arrayTestValues.put( 0.5, -0.69315);
        arrayTestValues.put( 2d, 0.693147);
        arrayTestValues.put( 3d, 1.098612);
        arrayTestValues.put( 10d, 2.302585);
    }

    @After
    public void tearDown() {
        arrayTestValues.clear();
    }

    @Test
    public void naturalLogarithmTest() {
        double expected, actual;
        for (Map.Entry<Double, Double> entry : arrayTestValues.entrySet()) {
            expected = entry.getValue();

            actual = ln.calculate(entry.getKey());
            if(expected == actual) {
                assertTrue(true);
            }
            else {
                assertTrue(checkTolerancy(expected, actual, 0.0001));
            }

        }
    }
}
