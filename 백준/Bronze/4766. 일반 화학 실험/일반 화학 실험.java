import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        double prev = Double.parseDouble(input);
        while (!(input = br.readLine()).equals("999")) {
            double current = Double.parseDouble(input);
            sb.append(String.format("%.2f", current - prev)).append("\n");
            prev = current;
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
