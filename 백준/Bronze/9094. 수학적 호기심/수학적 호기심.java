import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int count = 0;

            for (int a = 1; a < n - 1; a++) {
                for (int b = a + 1; b < n; b++) {
                    if ((a * a + b * b + m) % (a * b) == 0) {
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
