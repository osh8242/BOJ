import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        boolean[] isVisited = new boolean[N];
        int count = N;
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int I = Integer.parseInt(st.nextToken());
            for (int i = L - 1; i < N; i += I) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    count--;
                }
            }
        }
        sb.append(count);

        bw.write(sb.toString());
        bw.flush();
    }
}
