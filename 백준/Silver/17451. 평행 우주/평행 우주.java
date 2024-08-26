import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] v = new long[n];
        for (int i = 0; i < n; i++) {
            v[i] = Long.parseLong(st.nextToken());
        }

        // 마지막 행성에서 필요한 최소 속도는 v[n-1] 그대로
        long currentSpeed = v[n-1];

        // 역순으로 탐색하면서 현재 속도를 조정
        for (int i = n - 2; i >= 0; i--) {
            // 현재 행성의 요구 속도 v[i]를 만족시키는 속도의 배수 중에서
            // 현재 속도보다 크거나 같은 값으로 최소 속도를 맞춤
            if (currentSpeed % v[i] != 0) {
                currentSpeed = (currentSpeed / v[i] + 1) * v[i];
            }
        }

        // 결과 출력
        bw.write(String.valueOf(currentSpeed));
        bw.flush();
    }
}
