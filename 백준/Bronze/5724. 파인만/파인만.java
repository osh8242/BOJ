import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String input;

        while (!(input = br.readLine()).equals("0")) {
            int n = Integer.parseInt(input);
            sb.append(n * (n + 1) * (2 * n + 1) / 6).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
