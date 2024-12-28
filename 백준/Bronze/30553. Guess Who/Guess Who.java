import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        char[][] input = new char[N][M + 1];
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            if (M >= 0) System.arraycopy(chars, 0, input[i], 1, M);
        }
        boolean[] isVisited = new boolean[N];
        int count = N;
        Arrays.fill(isVisited, Boolean.FALSE);
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            char ch = st.nextToken().charAt(0);
            for (int i = 0; i < N; i++) {
                if (isVisited[i]) continue;
                if (input[i][index] != ch) {
                    isVisited[i] = true;
                    count--;
                }
            }
        }
        if (count == 1) {
            sb.append("unique").append("\n");
            for (int i = 0; i < N; i++) {
                if (!isVisited[i]) {
                    sb.append(i + 1);
                    break;
                }
            }
        } else {
            sb.append("ambiguous").append("\n").append(count);
        }
        System.out.println(sb);
    }
}
