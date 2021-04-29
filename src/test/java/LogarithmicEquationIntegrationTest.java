import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class LogarithmicEquationIntegrationTest {
    private static double tolerancy = 1e-3;
    private static NaturalLogarithm ln;
    private static RegularLogarithm log2;
    private static RegularLogarithm log3;
    private static RegularLogarithm log5;
    private static RegularLogarithm log10;
    private static LogarithmicEquation logarithmicEquation;

    @BeforeAll
    public static void init() {
        ln = Mockito.mock(NaturalLogarithm.class);
        when(ln.calculate(2d)).thenReturn(0.693147);
        when(ln.calculate(3d)).thenReturn(1.098612);
        when(ln.calculate(10d)).thenReturn(2.302585);

        log2 = Mockito.mock(RegularLogarithm.class);
        when(log2.calculate(2d)).thenReturn(1d);
        when(log2.calculate(3d)).thenReturn(1.584963);
        when(log2.calculate(10d)).thenReturn(3.321928);

        log3 = Mockito.mock(RegularLogarithm.class);
        when(log3.calculate(2d)).thenReturn(0.630929);
        when(log3.calculate(3d)).thenReturn(1d);
        when(log3.calculate(10d)).thenReturn(2.095903);

        log5 = Mockito.mock(RegularLogarithm.class);
        when(log5.calculate(2d)).thenReturn(0.430676);
        when(log5.calculate(3d)).thenReturn(0.682606);
        when(log5.calculate(10d)).thenReturn(1.430676);

        log10 = Mockito.mock(RegularLogarithm.class);
        when(log10.calculate(2d)).thenReturn(0.301029);
        when(log10.calculate(3d)).thenReturn(0.477121);
        when(log10.calculate(10d)).thenReturn(1d);

        logarithmicEquation = new LogarithmicEquation(ln,log2,log3,log5,log10);
    }

    @Test
    public void logarithmicEquationTest() {
        assertEquals(-0.000998267, logarithmicEquation.calculate(2), tolerancy);
        assertEquals(0.85776079958, logarithmicEquation.calculate(3), tolerancy);
        assertEquals(20.278015603, logarithmicEquation.calculate(10d), tolerancy);
    }

    @Test
    public void logarithimEquationIllegalArgumentTest(){
        assertThrows(IllegalArgumentException.class, () -> {
            logarithmicEquation.calculate(1d);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            logarithmicEquation.calculate(-1d);
        });
    }
}
