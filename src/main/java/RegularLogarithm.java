public class RegularLogarithm implements Calculatable {
    private NaturalLogarithm ln;
    private double base;

    public RegularLogarithm(NaturalLogarithm ln, double base) {
        this.ln = ln;
        this.base = base;
    }

    public double calculate(double x) {
        //System.out.println("x= " + x);
        //System.out.println("ln(x)= " + ln.calculate(x) + "\n" + "base =" + base + "\n" + "ln(base) =" + ln.calculate(base));
        return ln.calculate(x) / ln.calculate(base);
    }
}
