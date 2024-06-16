import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Double value = Double.parseDouble(st.nextToken());
            String unit = st.nextToken();
            bw.write(convert(value, unit));
            bw.newLine();
        }

        bw.flush();
    }

    static String convert(Double value, String unit) {
        StringBuilder sb = new StringBuilder();
        return switch (unit) {
            case "kg" -> sb.append(String.format("%.4f", value * 2.2046)).append(" lb").toString();
            case "lb" -> sb.append(String.format("%.4f", value * 0.4536)).append(" kg").toString();
            case "l" -> sb.append(String.format("%.4f", value * 0.2642)).append(" g").toString();
            case "g" -> sb.append(String.format("%.4f", value * 3.7854)).append(" l").toString();
            default -> "null";
        };
    }
}
