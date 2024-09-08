import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static long K;
    static long[] A;

    public static void main(String[] args) throws IOException {
        // 첫 번째 줄 입력 처리 (N: 학생 수, K: 사탕 최대 개수)
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        // 두 번째 줄 입력 처리 (각 학생들의 점수 A 배열)
        A = new long[N];
        st = new StringTokenizer(br.readLine()); // 두 번째 줄 입력 처리
        long maxScore = 0;

        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
            maxScore = Math.max(maxScore, A[i]);
        }

        // 이분 탐색을 위한 변수 설정
        long answer = getAnswerByBinarySearch(maxScore);

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    private static long getAnswerByBinarySearch(long maxScore) {
        long left = 0;           // 가능한 최소 X
        long right = maxScore;    // 가능한 최대 X
        long answer = maxScore;   // 최종 정답 저장할 변수

        // 이분 탐색 시작
        while (left <= right) {
            long mid = (left + right) / 2; // 중간 값 X 후보

            // 주어진 X = mid일 때 필요한 사탕의 개수를 계산
            long candyNeeded = 0;

            // 각 학생에 대해 A_i > mid인 경우만 사탕을 줌
            for (int i = 0; i < N; i++) {
                if (A[i] > mid) {
                    candyNeeded += (A[i] - mid);
                    // 사탕 수가 K를 넘으면 더 이상 계산할 필요 없음
                    if (candyNeeded > K) {
                        break;
                    }
                }
            }

            // 사탕 수가 K 이하라면 X를 줄여볼 수 있다.
            if (candyNeeded <= K) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}
