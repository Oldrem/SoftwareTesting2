import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class EquationSystemIntegrationTest {
    private double accuracy = 1e-5;
    private static  EquationSystem equationSystem;
    private static TrigonometricEquation trigonometricEquation;
    private static LogarithmicEquation logarithmicEquation;

    @BeforeAll
    public static void init() {
        trigonometricEquation = Mockito.mock(TrigonometricEquation.class);

        //TODO calculate
        //when(trigonometricEquation.calculate(0d)).thenReturn(0d);
        when(trigonometricEquation.calculate(-Math.PI/3)).thenReturn(-3.5004);
        when(trigonometricEquation.calculate(-Math.PI*2/3)).thenReturn(1.6543);
        when(trigonometricEquation.calculate(-1.5)).thenReturn(-15.2052);

        logarithmicEquation = Mockito.mock(LogarithmicEquation.class);


        //when(logarithmicEquation.calculate(0d)).thenThrow(new IllegalArgumentException(""));
        when(logarithmicEquation.calculate(0.5)).thenReturn(-0.55748);
        when(logarithmicEquation.calculate(2d)).thenReturn(-0.000998267);
        when(logarithmicEquation.calculate(3d)).thenReturn(0.85776079958);
        when(logarithmicEquation.calculate(10d)).thenReturn(20.278015603);

        equationSystem = new EquationSystem(trigonometricEquation, logarithmicEquation);
    }

    @Test
    public void trigonometricTest() {
        assertEquals(-3.5004, equationSystem.calculate(-Math.PI/3), accuracy);
        assertEquals(1.6543, equationSystem.calculate(-Math.PI*2/3), accuracy);
        assertEquals(-15.2052, equationSystem.calculate(-1.5), accuracy);
    }

    @Test
    public void logarithmicTest() {
        assertEquals(-0.55748, equationSystem.calculate(0.5), accuracy);
        assertEquals(-0.000998267, equationSystem.calculate(2d), accuracy);
        assertEquals(0.85776079958, equationSystem.calculate(3d), accuracy);
        assertEquals(20.278015603, equationSystem.calculate(10d), accuracy);
    }
}
