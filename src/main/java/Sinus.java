import static java.lang.Math.*;

public class Sinus implements Calculatable {
    private double tolerancy;

    public Sinus(double tolerancy) {
        this.tolerancy = tolerancy;
    }

    private double adjustToSeriesBoundaries(double x) {
        if (x > PI || x < -PI) {
            double k = x % (2 * PI);
            if (k < -PI) {
                return k + 2 * PI;
            }
            if (k > PI) {
                return k - 2 * PI;
            }
            return k;
        } else {
            return x;
        }
    }

    public double calculate(double x) {
        x = adjustToSeriesBoundaries(x);
        double result = 0d;
        double current = 10d;
        double previous = 0d;
        int n = 0;
        while (Math.abs(previous - current) >= tolerancy) {
            previous = current;
            current = calculateSeries(x, n);
            result += current;
            n++;
        }
        return result;
    }

    private double calculateSeries(double val, int n) {
        return pow(-1, n) * pow(val, 2 * n + 1) / factorial(2 * n + 1);
    }

    private long factorial(long val) {
        if (val <= 1)
            return 1;
        else
            return val * (factorial(val - 1));
    }
}

