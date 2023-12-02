import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double weight = -1;
        while ((weight = Double.parseDouble(br.readLine())) != -1) {
            System.out.printf("Objects weighing %.2f on Earth will weigh %.2f on the moon.\n", weight, weight * 0.167);
        }
    }
}