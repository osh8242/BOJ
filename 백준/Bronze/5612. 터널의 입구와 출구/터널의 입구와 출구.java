import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int max;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        max = m;

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int inCount = Integer.parseInt(st.nextToken());
            int outCount = Integer.parseInt(st.nextToken());

            m += inCount - outCount;
            if (m < 0) {
                max = 0;
                break;
            }
            max = Math.max(max, m);
        }

        bw.write(Integer.toString(max));
        bw.flush();
    }
}
