import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double weight = Double.parseDouble(br.readLine());
        double height = Double.parseDouble(br.readLine());
        System.out.println(getBmiCategory(weight, height));
    }

    static String getBmiCategory(double weight, double height) {
        double bmi = getBmi(weight, height);
        if (bmi > 25) return "Overweight";
        else if (bmi < 18.5) return "Underweight";
        else return "Normal weight";
    }

    static double getBmi(double weight, double height) {
        return weight / (height * height);
    }
}
