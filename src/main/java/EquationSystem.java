public class EquationSystem implements Calculatable {
    TrigonometricEquation trigonometricEquation;
    LogarithmicEquation logarithmicEquation;

    public EquationSystem(TrigonometricEquation trigonometricEquation, LogarithmicEquation logarithmicEquation) {
        this.trigonometricEquation = trigonometricEquation;
        this.logarithmicEquation = logarithmicEquation;
    }

    public double calculate(double x) {
        if (x <= 0) {
           return trigonometricEquation.calculate(x);
        } else {
           return logarithmicEquation.calculate(x);
        }
    }
}
