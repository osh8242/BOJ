import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int caseNum = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            if (L == 0 && P == 0 && V == 0) break;
            int full = V / P;
            int rem = V % P;
            int extra = rem < L ? rem : L;
            int result = full * L + extra;
            sb.append("Case ").append(caseNum++).append(": ").append(result).append('\n');
        }
        System.out.print(sb);
    }
}
