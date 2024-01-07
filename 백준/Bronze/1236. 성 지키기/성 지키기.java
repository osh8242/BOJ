import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] rowCheck = new boolean[N];
        boolean[] colCheck = new boolean[M];
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (line[j] == 'X') {
                    rowCheck[i] = true;
                    colCheck[j] = true;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!rowCheck[i] && !colCheck[j]) {
                    answer++;
                    rowCheck[i] = true;
                    colCheck[j] = true;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (!rowCheck[i]) answer++;
        }
        for (int j = 0; j < M; j++) {
            if (!colCheck[j]) answer++;
        }
        System.out.println(answer);

    }

}