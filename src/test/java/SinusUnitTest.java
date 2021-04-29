import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SinusUnitTest {
    private HashMap<Double, Double> arrayTestValues = new HashMap<>();
    private static final double tolerancy = 0.001;
    private Sinus sin = new Sinus(tolerancy);

    @Before
    public void setUp() {
        arrayTestValues.put( 0d, 0d);
        arrayTestValues.put(Math.PI / 6, 0.5);
        arrayTestValues.put(Math.PI / 3, Math.sqrt(3) / 2);
        arrayTestValues.put(Math.PI / 4, Math.sqrt(2) / 2);
        arrayTestValues.put(2*Math.PI / 3, Math.sqrt(3.0) / 2);
        arrayTestValues.put(5*Math.PI / 6, 0.5);
        arrayTestValues.put(Math.PI / 2, 1d);
        arrayTestValues.put(3* Math.PI / 4, Math.sqrt(2) / 2);
        arrayTestValues.put(-Math.PI / 6, -0.5);
        arrayTestValues.put(-Math.PI / 3, -Math.sqrt(3) / 2);
        arrayTestValues.put(-Math.PI / 4, -Math.sqrt(2) / 2);
        arrayTestValues.put(-2*Math.PI / 3, -Math.sqrt(3) / 2);
        arrayTestValues.put(-5*Math.PI / 6, -0.5);
        arrayTestValues.put(-Math.PI / 2, -1d);
        arrayTestValues.put(-3* Math.PI / 4, -Math.sqrt(2) / 2);
        arrayTestValues.put(-Math.PI, 0d);
        arrayTestValues.put(Math.PI, 0d);
        arrayTestValues.put(7*Math.PI / 6, -0.5);
        arrayTestValues.put(-7*Math.PI / 6, 0.5);
    }

    @After
    public void destroy() {
        arrayTestValues.clear();
    }

    @Test
    public void sinusTest() {
        double expected, actual;
        for (Map.Entry<Double, Double> entry : arrayTestValues.entrySet()) {
            expected = entry.getValue();
            actual = sin.calculate(entry.getKey());
            assertEquals(expected, actual, tolerancy);
        }
    }
}
