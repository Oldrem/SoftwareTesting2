import static java.lang.StrictMath.pow;

public class NaturalLogarithm implements Calculatable {
    private double tolerancy;
    private double ln2;

    public NaturalLogarithm(double tolerancy) {
        this.tolerancy = tolerancy * 0.1;
        ln2 = calculate(2.0);
    }

    public double calculate(double x) {

        if (x > 2) return calculate(x / 2d) + ln2;
        if (x == 0d) return Double.NEGATIVE_INFINITY;
        double result = 0d;
        double current = 10d;
        double prev = 0d;
        int n = 1;
        while (Math.abs(prev - current) >= tolerancy) {
            prev = current;
            current = calculateSeries(x, n);
            result += current;
            n++;
        }
        return result;
    }

    private double calculateSeries(double val, int n) {
        return pow(- 1, n-1) * pow(val-1, n)/n;
    }
}
