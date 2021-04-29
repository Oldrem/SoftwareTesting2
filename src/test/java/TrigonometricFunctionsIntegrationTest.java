import org.junit.jupiter.api.BeforeAll;
        import org.junit.jupiter.api.Test;
        import org.mockito.Mockito;

        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.mockito.Mockito.when;

public class TrigonometricFunctionsIntegrationTest {
    private static double tolerancy = 0.1;
    private static Sinus sin;
    private static Cosine cos;
    private static Tangent tan;
    private static Cotangent cot;
    private static Secant sec;


    @BeforeAll
    public static void setup() {
        sin = Mockito.mock(Sinus.class);

        when(sin.calculate(0d)).thenReturn(0d);
        when(sin.calculate(-Math.PI/3)).thenReturn(-0.866025404);
        when(sin.calculate(-Math.PI/2)).thenReturn(-1d);
        when(sin.calculate(-Math.PI*3/2)).thenReturn(1d);

        cos = new Cosine(sin);
        tan = new Tangent(sin,cos);
        cot = new Cotangent(sin, cos);
        sec = new Secant(cos);
    }

    @Test
    public void cosIntegrationTest() {
        assertEquals(1d, cos.calculate(0d), tolerancy);
        assertEquals(0.5, cos.calculate(-Math.PI/3), tolerancy);
        assertEquals(0d, cos.calculate(-Math.PI/2), tolerancy);
        assertEquals(0d, cos.calculate(-Math.PI*3/2), tolerancy);
    }
    @Test
    public void tanIntegrationTest() {
        assertEquals(0d, tan.calculate(0d), tolerancy);
        assertEquals(-1.73205081, tan.calculate(-Math.PI/3), tolerancy);
        assertEquals(Double.NEGATIVE_INFINITY, tan.calculate(-Math.PI/2), tolerancy);
        assertEquals(Double.POSITIVE_INFINITY, tan.calculate(-Math.PI*3/2), tolerancy);
    }
    @Test
    public void cotIntegrationTest() {
        assertEquals(Double.POSITIVE_INFINITY, cot.calculate(0d), tolerancy);
        assertEquals(-0.57735027, cot.calculate(-Math.PI/3), tolerancy);
        assertEquals(0d, cot.calculate(-Math.PI/2), tolerancy);
        assertEquals(0d, cot.calculate(-Math.PI*3/2), tolerancy);
    }
    @Test
    public void secIntegrationTest() {
        assertEquals(1d, sec.calculate(0d), tolerancy);
        assertEquals(2d, sec.calculate(-Math.PI/3), tolerancy);
        assertEquals(Double.POSITIVE_INFINITY, sec.calculate(-Math.PI/2), tolerancy);
        assertEquals(Double.POSITIVE_INFINITY, sec.calculate(-Math.PI*3/2), tolerancy);
    }
}
