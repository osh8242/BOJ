import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (N-- > 0) {
                int value = Integer.parseInt(st.nextToken());
                max = Math.max(max, value);
                min = Math.min(min, value);
            }
            sb.append(min).append(" ").append(max).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
