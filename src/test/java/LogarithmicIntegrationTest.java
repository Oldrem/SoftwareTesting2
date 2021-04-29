import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class LogarithmicIntegrationTest {
    private static double tolerancy = 1e-5;
    private static NaturalLogarithm ln;
    private static RegularLogarithm log2;
    private static RegularLogarithm log3;
    private static RegularLogarithm log5;
    private static RegularLogarithm log10;

    @BeforeAll
    public static void init() {
        ln = Mockito.mock(NaturalLogarithm.class);

        when(ln.calculate(0.5)).thenReturn(-0.693147181);
        when(ln.calculate(1d)).thenReturn(0d);
        when(ln.calculate(2d)).thenReturn(0.693147);
        when(ln.calculate(3d)).thenReturn(1.098612);
        when(ln.calculate(5d)).thenReturn(1.60943791);
        when(ln.calculate(10d)).thenReturn(2.30258509);

        log2 = new RegularLogarithm(ln, 2);
        log3 = new RegularLogarithm(ln, 3);
        log5 = new RegularLogarithm(ln, 5);
        log10 = new RegularLogarithm(ln, 10);
    }

    @Test
    public void log2Test() {
        assertEquals(-1, log2.calculate(0.5), tolerancy);
        assertEquals(1, log2.calculate(2d), tolerancy);
        assertEquals(1.584962501, log2.calculate(3d), tolerancy);
        assertEquals(3.321928095, log2.calculate(10d), tolerancy);
    }

    @Test
    public void log3Test() {
        assertEquals(0.630929754, log3.calculate(2d), tolerancy);
        assertEquals(1, log3.calculate(3d), tolerancy);
        assertEquals(2.095903274, log3.calculate(10d), tolerancy);
    }

    @Test
    public void log5Test() {
        assertEquals(0.430676558, log5.calculate(2d), tolerancy);
        assertEquals(0.682606194, log5.calculate(3d), tolerancy);
        assertEquals(1.430676558, log5.calculate(10d), tolerancy);
    }

    @Test
    public void log10Test() {
        assertEquals(0.301029996, log10.calculate(2d), tolerancy);
        assertEquals(0.477121255, log10.calculate(3d), tolerancy);
        assertEquals(1, log10.calculate(10d), tolerancy);
    }
}
