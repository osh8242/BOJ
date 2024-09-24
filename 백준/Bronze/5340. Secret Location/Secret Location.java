import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String x1 = Integer.toString(br.readLine().trim().length());
        String x2 = Integer.toString(br.readLine().trim().length());
        String x3 = Integer.toString(br.readLine().trim().length());
        String x4 = Integer.toString(br.readLine().trim().length());
        String x5 = Integer.toString(br.readLine().trim().length());
        String x6 = Integer.toString(br.readLine().trim().length());

        sb.append("Latitude ").append(String.join(":", x1, x2, x3)).append("\n");
        sb.append("Longitude ").append(String.join(":", x4, x5, x6));

        bw.write(sb.toString());
        bw.flush();
    }
}
