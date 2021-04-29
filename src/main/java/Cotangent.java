public class Cotangent implements Calculatable{
    private Sinus sin;
    private Cosine cos;

    public Cotangent(Sinus sin, Cosine cos) {
        this.sin = sin;
        this.cos = cos;
    }

    public double calculate(double x) {
        return cos.calculate(x)/sin.calculate(x);
    }
}
