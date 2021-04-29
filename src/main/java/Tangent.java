public class Tangent implements Calculatable{
    private Sinus sin;
    private Cosine cos;

    public Tangent(Sinus sin, Cosine cos) {
        this.sin = sin;
        this.cos = cos;
    }

    public double calculate(double x) {
        return sin.calculate(x)/cos.calculate(x);
    }
}
