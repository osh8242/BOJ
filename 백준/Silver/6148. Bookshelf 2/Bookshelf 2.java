import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, B;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(answer < B) answer += arr[i];
            else if (answer == B) break;
        }

        if(answer != B) dfs(0, 0);

        bw.write(Integer.toString(answer - B));
        bw.flush();
    }

    static void dfs(int index, int sum) {
        if (sum >= answer) return;
        if (index == N) {
            if (sum >= B) answer = Math.min(answer, sum);
            return;
        }

        dfs(index + 1, sum + arr[index]);
        dfs(index + 1, sum);

    }

}
