public class Secant implements Calculatable{
    private Sinus sin;
    private Cosine cos;

    public Secant(Cosine cos) {
        this.cos = cos;
    }

    public double calculate(double x) {
        return 1/cos.calculate(x);
    }
}
