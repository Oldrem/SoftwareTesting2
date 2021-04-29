import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FullIntegration {

    private static double tolerancy = 1e-2;
    private static MainEquationSystem system;

    @BeforeAll
    public static void init() {
        Sinus sin = new Sinus(tolerancy);
        Cosine cos = new Cosine(sin);
        Tangent tan = new Tangent(sin, cos);
        Cotangent cot = new Cotangent(sin, cos);
        Secant sec = new Secant(cos);
        NaturalLogarithm ln = new NaturalLogarithm(tolerancy);
        RegularLogarithm log2 = new RegularLogarithm(ln, 2);
        RegularLogarithm log3 = new RegularLogarithm(ln, 3);
        RegularLogarithm log5 = new RegularLogarithm(ln, 5);
        RegularLogarithm log10 = new RegularLogarithm(ln, 10);
        TrigonometricEquation trigonometricEquation = new TrigonometricEquation(sin, cos, tan, cot, sec);
        LogarithmicEquation logarithmicEquation = new LogarithmicEquation(ln, log2, log3, log5, log10);
        system = new MainEquationSystem(trigonometricEquation, logarithmicEquation);
    }

    @Test
    public void fullIntegrationTest() {
        assertEquals(-3.5004, system.calculate(-Math.PI/3), tolerancy);
        assertEquals(-15.2052, system.calculate(-1.5), tolerancy);
        assertEquals(-0.55748, system.calculate(0.5), tolerancy);
        assertEquals(-0.000998267, system.calculate(2d), tolerancy);
        assertEquals(0.85776079958, system.calculate(3d), tolerancy);
        assertEquals(20.278015603, system.calculate(10d), tolerancy);
    }
}
