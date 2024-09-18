import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int scenarios = Integer.parseInt(br.readLine());

        for (int i = 1; i <= scenarios; i++) {
            String[] input = br.readLine().split(" ");
            double R = Double.parseDouble(input[0]);
            int n = Integer.parseInt(input[1]);

            double r = (R * Math.sin(Math.PI / n)) / (1 + Math.sin(Math.PI / n));

            sb.append("Scenario #").append(i).append(":\n");
            sb.append(String.format("%.3f", r)).append("\n\n");
        }

        bw.write(sb.toString());

        bw.flush();
    }
}
