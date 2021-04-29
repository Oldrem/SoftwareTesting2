import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class CsvLogger {

    public static void writeLog(Calculatable module, String name, double from,
                                      double to, double step) {

        File file = new File("src/main/resources/" + name + ".csv");

        try {
            FileWriter writer = new FileWriter(file);
            writer.write("X," + name + '\n');
            for (double i = from; i < to; i += step) {
                writer.write(String.format("%f", i) + ';' + String.format("%f", module.calculate(i)) + '\n');
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
