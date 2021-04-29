import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SinusUnitTest {
    private static final double tolerancy = 0.001;
    private Sinus sin = new Sinus(tolerancy);
    private HashMap<Double, Double> tests = new HashMap<>();

    @Before
    public void init() {
        tests.put( 0d, 0d);
        tests.put(Math.PI / 6, 0.5);
        tests.put(Math.PI / 3, Math.sqrt(3) / 2);
        tests.put(Math.PI / 4, Math.sqrt(2) / 2);
        tests.put(2*Math.PI / 3, Math.sqrt(3.0) / 2);
        tests.put(5*Math.PI / 6, 0.5);
        tests.put(Math.PI / 2, 1d);
        tests.put(3* Math.PI / 4, Math.sqrt(2) / 2);
        tests.put(-Math.PI / 6, -0.5);
        tests.put(-Math.PI / 3, -Math.sqrt(3) / 2);
        tests.put(-Math.PI / 4, -Math.sqrt(2) / 2);
        tests.put(-2*Math.PI / 3, -Math.sqrt(3) / 2);
        tests.put(-5*Math.PI / 6, -0.5);
        tests.put(-Math.PI / 2, -1d);
        tests.put(-3* Math.PI / 4, -Math.sqrt(2) / 2);
        tests.put(-Math.PI, 0d);
        tests.put(Math.PI, 0d);
        tests.put(7*Math.PI / 6, -0.5);
        tests.put(-7*Math.PI / 6, 0.5);
    }

    @After
    public void destroy() {
        tests.clear();
    }

    @Test
    public void sinusTest() {
        double expected, actual;
        for (Map.Entry<Double, Double> entry : tests.entrySet()) {
            expected = entry.getValue();
            actual = sin.calculate(entry.getKey());
            assertEquals(expected, actual, tolerancy);
        }
    }
}
