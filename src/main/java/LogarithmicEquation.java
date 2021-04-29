public class LogarithmicEquation implements Calculatable {
    private NaturalLogarithm ln;
    private RegularLogarithm log2;
    private RegularLogarithm log3;
    private RegularLogarithm log5;
    private RegularLogarithm log10;

    public LogarithmicEquation(NaturalLogarithm ln, RegularLogarithm log2, RegularLogarithm log3, RegularLogarithm log5, RegularLogarithm log10) {
        this.ln = ln;
        this.log2 = log2;
        this.log3 = log3;
        this.log5 = log5;
        this.log10 = log10;
    }

    public double calculate(double x) throws ArithmeticException {
        if (x == 1 || x <= 0) throw new IllegalArgumentException("Функция на данном промежутке не опеределена.");
        //if (log2.calculate(x) == 0) throw new ArithmeticException("Деление на ноль!");
        return (((((ln.calculate(x) * log5.calculate(x)) - log10.calculate(x)) - ((log2.calculate(x) / log2.calculate(x)) - log2.calculate(x))) * log3.calculate(x)) * log3.calculate(x));
    }
}
