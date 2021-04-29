public class Cosine implements Calculatable{
    private Sinus sin;

    public Cosine(Sinus sin) {
        this.sin = sin;
    }

    public double calculate(double x) {
        double sinusResult = sin.calculate(x);
        return Math.sqrt(1 - sinusResult*sinusResult);
    }
}
