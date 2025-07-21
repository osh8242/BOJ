import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        double x = Double.parseDouble(st.nextToken());
        double[] a = new double[n];
        st = new StringTokenizer(br.readLine());
        double sumsq = 0;
        for (int i = 0; i < n; i++) {
            a[i] = Double.parseDouble(st.nextToken());
            sumsq += a[i] * a[i];
        }
        StringBuilder sb = new StringBuilder();
        if (sumsq == 0) {
            for (int i = 0; i < n; i++) {
                if (i > 0) sb.append(' ');
                sb.append("0.0");
            }
        } else {
            double mean = sumsq / n;
            double c = Math.sqrt(x / mean);
            for (int i = 0; i < n; i++) {
                if (i > 0) sb.append(' ');
                sb.append(a[i] * c);
            }
        }
        System.out.println(sb);
    }
}
