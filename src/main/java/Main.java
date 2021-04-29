public class Main {
    public static void main(String[] args) {
        double tolerancy = 0.001;
        Sinus sin = new Sinus(tolerancy);
        Cosine cos = new Cosine(sin);
        Tangent tan = new Tangent(sin, cos);
        Cotangent cot = new Cotangent(sin, cos);
        Secant sec = new Secant(cos);
        NaturalLogarithm ln = new NaturalLogarithm(tolerancy);
        RegularLogarithm log2 = new RegularLogarithm(ln, 2);
        RegularLogarithm log3 = new RegularLogarithm(ln, 3);
        RegularLogarithm log5 = new RegularLogarithm(ln, 5);
        RegularLogarithm log10 = new RegularLogarithm(ln, 10);
        TrigonometricEquation trigonometricEquation = new TrigonometricEquation(sin, cos, tan, cot, sec);
        LogarithmicEquation logarithmicEquation = new LogarithmicEquation(ln, log2, log3, log5, log10);
        EquationSystem system = new EquationSystem(trigonometricEquation, logarithmicEquation);
        CsvLogger.writeLog(system, "EquationSystem", -5.05,10,0.1);
        CsvLogger.writeLog(logarithmicEquation, "LogarithmicEquation", 1.1,10,0.1);
        CsvLogger.writeLog(trigonometricEquation, "TrigonometricEquation", -5,0,0.1);
        CsvLogger.writeLog(ln, "NaturalLogarithm", 0.001,14,0.1);
        CsvLogger.writeLog(log2, "LogarithmBase2", 0.001,20,0.1);
        CsvLogger.writeLog(sin, "Sinus", -8,8,0.1);
        CsvLogger.writeLog(cos, "Cosine", -8,8,0.1);
        CsvLogger.writeLog(tan, "Tangent", -8,8,0.1);
        CsvLogger.writeLog(cot, "Cotangent", -8,8,0.1);
        CsvLogger.writeLog(sec, "Secant", -8,8,0.1);
    }
}
