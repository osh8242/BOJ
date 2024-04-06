import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 점의 개수 N 읽기
        long[] x = new long[N];
        long[] y = new long[N];
        
        // 점의 좌표 입력 받기
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            x[i] = Long.parseLong(input[0]);
            y[i] = Long.parseLong(input[1]);
        }

        // 신발끈 공식을 사용하여 면적 계산
        double area = 0;
        for (int i = 0; i < N - 1; i++) {
            area += x[i] * y[i + 1] - y[i] * x[i + 1];
        }
        // 마지막 점과 첫 번째 점을 연결하는 선분 고려
        area += x[N - 1] * y[0] - y[N - 1] * x[0];
        
        // 절대값을 취한 후 2로 나누어 면적을 최종 계산
        area = Math.abs(area) / 2.0;

        // 면적을 출력
        System.out.printf("%.1f\n", area);
        
        br.close();
    }
}
