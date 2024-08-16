import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());

            double minX = Integer.MAX_VALUE;
            double minY = Integer.MAX_VALUE;
            double maxX = Integer.MIN_VALUE;
            double maxY = Integer.MIN_VALUE;

            while (N-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                double x = Double.parseDouble(st.nextToken());
                double y = Double.parseDouble(st.nextToken());
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
            }

            double area = (maxX - minX) * (maxY - minY);
            double perimeter = 2 * ((maxX - minX) + (maxY - minY));

            sb.append("Case ").append(i).append(": Area ").append(area)
              .append(", Perimeter ").append(perimeter).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
