import static java.lang.Math.*;

public class TrigonometricEquation implements Calculatable {
    private Sinus sin;
    private Cosine cos;
    private Tangent tan;
    private Cotangent cot;
    private Secant sec;

    public TrigonometricEquation(Sinus sin, Cosine cos, Tangent tan, Cotangent cot, Secant sec) {
        this.sin = sin;
        this.cos = cos;
        this.tan = tan;
        this.cot = cot;
        this.sec = sec;
    }

    public double calculate(double x) {
        if (sin.calculate(x) == 0 || tan.calculate(x) == 0) throw new IllegalArgumentException("Функция на данном промежутке не опеределена.");
        if (x % Math.PI == 0) throw new IllegalArgumentException("Функция на данном промежутке не опеределена.");

        return ((pow((cot.calculate(x) / sin.calculate(x)) / tan.calculate(x), 3)) + ((sin.calculate(x) - sec.calculate(x)) + cot.calculate(x)));
    }
}
