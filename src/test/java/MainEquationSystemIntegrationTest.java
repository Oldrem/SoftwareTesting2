import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class MainEquationSystemIntegrationTest {
    private double tolerancy = 1e-5;
    private static MainEquationSystem equationSystem;
    private static TrigonometricEquation trigonometricEquation;
    private static LogarithmicEquation logarithmicEquation;

    @BeforeAll
    public static void init() {
        trigonometricEquation = Mockito.mock(TrigonometricEquation.class);
        when(trigonometricEquation.calculate(-Math.PI/3)).thenReturn(-3.5004);
        when(trigonometricEquation.calculate(-Math.PI*2/3)).thenReturn(1.6543);
        when(trigonometricEquation.calculate(-1.5)).thenReturn(-15.2052);
        when(trigonometricEquation.calculate(-0.6)).thenReturn(-57.4158);

        logarithmicEquation = Mockito.mock(LogarithmicEquation.class);
        when(logarithmicEquation.calculate(0.5)).thenReturn(-0.55748);
        when(logarithmicEquation.calculate(2d)).thenReturn(-0.000998267);
        when(logarithmicEquation.calculate(3d)).thenReturn(0.85776079958);
        when(logarithmicEquation.calculate(10d)).thenReturn(20.278015603);

        equationSystem = new MainEquationSystem(trigonometricEquation, logarithmicEquation);
    }

    @Test
    public void trigonometricTest() {
        assertEquals(-3.5004, equationSystem.calculate(-Math.PI/3), tolerancy);
        assertEquals(1.6543, equationSystem.calculate(-Math.PI*2/3), tolerancy);
        assertEquals(-15.2052, equationSystem.calculate(-1.5), tolerancy);
        assertEquals(-57.4158, equationSystem.calculate(-0.6), tolerancy);
    }

    @Test
    public void logarithmicTest() {
        assertEquals(-0.55748, equationSystem.calculate(0.5), tolerancy);
        assertEquals(-0.000998267, equationSystem.calculate(2d), tolerancy);
        assertEquals(0.85776079958, equationSystem.calculate(3d), tolerancy);
        assertEquals(20.278015603, equationSystem.calculate(10d), tolerancy);
    }
}
