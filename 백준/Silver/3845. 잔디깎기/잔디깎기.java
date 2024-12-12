import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nx = Integer.parseInt(st.nextToken());
            int ny = Integer.parseInt(st.nextToken());
            double w = Double.parseDouble(st.nextToken());
            if (nx == 0 && ny == 0 && w == 0) break;

            st = new StringTokenizer(br.readLine());
            double[] nxArr = new double[nx];
            for (int i = 0; i < nx; i++) {
                nxArr[i] = Double.parseDouble(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            double[] nyArr = new double[ny];
            for (int i = 0; i < ny; i++) {
                nyArr[i] = Double.parseDouble(st.nextToken());
            }
            Arrays.sort(nxArr);
            Arrays.sort(nyArr);
            boolean success = true;
            double current = 0;
            for (double xi : nxArr) {
                if (2 * (xi - current) > w) {
                    success = false;
                    break;
                }
                current = xi + w / 2.0;
            }
            if (current < 75.0) success = false;

            current = 0;
            if (success) {
                for (double yi : nyArr) {
                    if (2 * (yi - current) > w) {
                        success = false;
                        break;
                    }
                    current = yi + w / 2.0;
                }
            }
            if (current < 100.0) success = false;

            sb.append(success ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }
}
