import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        boolean[] seen = new boolean[1000001];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // 현재 화분의 모든 숫자가 이전에 등장하지 않았다면, 직접 깨야 함
            if (!seen[a] && !seen[b] && !seen[c]) {
                answer++;
            }
            // 현재 화분의 숫자들을 seen 배열에 표시
            seen[a] = true;
            seen[b] = true;
            seen[c] = true;
        }
        System.out.println(answer);
    }
}
