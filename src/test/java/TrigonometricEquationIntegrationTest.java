import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class TrigonometricEquationIntegrationTest {
    private static double tolerancy = 1e-3;
    private static Sinus sin;
    private static Cosine cos;
    private static Tangent tan;
    private static Cotangent cot;
    private static Secant sec;
    private static TrigonometricEquation trigonometricEquation;

    @BeforeAll
    public static void init() {

        cos = Mockito.mock(Cosine.class);
        tan = Mockito.mock(Tangent.class);
        cot = Mockito.mock(Cotangent.class);
        sec = Mockito.mock(Secant.class);

        sin = Mockito.mock(Sinus.class);
        when(sin.calculate(0d)).thenReturn(0d);
        when(sin.calculate(-Math.PI/3)).thenReturn(-0.866025404);
        when(sin.calculate(-Math.PI*2/3)).thenReturn(-0.866025404);
        when(sin.calculate(-1.5)).thenReturn(-0.997494987);
        when(sin.calculate(-0.6)).thenReturn(-0.564642473);

        cos = Mockito.mock(Cosine.class);
        when(cos.calculate(0d)).thenReturn(1d);
        when(cos.calculate(-Math.PI/3)).thenReturn(0.5);
        when(cos.calculate(-Math.PI*2/3)).thenReturn(-0.5);
        when(cos.calculate(-1.5)).thenReturn(0.0707372017);
        when(cos.calculate(-0.6)).thenReturn(0.825335615);

        tan = Mockito.mock(Tangent.class);
        when(tan.calculate(0d)).thenReturn(0d);
        when(tan.calculate(-Math.PI/3)).thenReturn(-1.7320508);
        when(tan.calculate(-Math.PI*2/3)).thenReturn(1.7320508);
        when(tan.calculate(-1.5)).thenReturn(-14.10141995);
        when(tan.calculate(-0.6)).thenReturn(-0.684136808);

        cot = Mockito.mock(Cotangent.class);
        when(cot.calculate(0d)).thenReturn(0d);
        when(cot.calculate(-Math.PI/3)).thenReturn(-0.57735027);
        when(cot.calculate(-Math.PI*2/3)).thenReturn(0.57735027);
        when(cot.calculate(-1.5)).thenReturn(-0.07091484);
        when(cot.calculate(-0.6)).thenReturn(-1.46169595);

        sec = Mockito.mock(Secant.class);
        when(sec.calculate(0d)).thenReturn(1d);
        when(sec.calculate(-Math.PI/3)).thenReturn(2d);
        when(sec.calculate(-Math.PI*2/3)).thenReturn(-2d);
        when(sec.calculate(-1.5)).thenReturn(14.136832902);
        when(sec.calculate(-0.6)).thenReturn(1.21162831);

        trigonometricEquation = new TrigonometricEquation(sin, cos, tan, cot, sec);
    }

    @Test
    public void trigonometricEquationTest() {
        assertEquals(-3.5004, trigonometricEquation.calculate(-Math.PI/3), tolerancy);
        assertEquals(1.6543, trigonometricEquation.calculate(-Math.PI*2/3), tolerancy);
        assertEquals(-15.2052, trigonometricEquation.calculate(-1.5), tolerancy);
        assertEquals(-57.4158, trigonometricEquation.calculate(-0.6), tolerancy);
    }

    @Test
    public void trigonometricEquationIllegalArgumentTest(){
        assertThrows(IllegalArgumentException.class, () -> {
            trigonometricEquation.calculate(0d);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            trigonometricEquation.calculate(Math.PI);
        });
    }
}
