import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            double totalUnit = 0;
            double pointSum = 0;
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                double unit = Double.parseDouble(st.nextToken());
                double point = Double.parseDouble(st.nextToken());
                totalUnit += unit;
                pointSum += unit * point;
            }
            sb.append((int) totalUnit).append(" ").append(pointSum / totalUnit).append("\n");
        }
        System.out.println(sb);
    }
}
