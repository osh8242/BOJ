import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 현재 점수 개수
        int S = Integer.parseInt(st.nextToken()); // 새로운 점수
        int P = Integer.parseInt(st.nextToken()); // 최대 랭킹 리스트 크기

        if (N == 0) {
            // 현재 리스트가 비어 있는 경우
            System.out.println(1);
            return;
        }

        int[] scores = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        // 이진 탐색으로 삽입 위치 찾기
        int rank = findRank(scores, S);

        // 리스트가 가득 찬 경우 추가 점수 조건 확인
        if (N >= P && (rank > P || S <= scores[N - 1])) {
            System.out.println(-1);
        } else {
            System.out.println(rank);
        }
    }

    // 이진 탐색으로 새로운 점수의 등수를 계산
    static int findRank(int[] scores, int point) {
        int left = 0;
        int right = scores.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (scores[mid] <= point) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right + 2; // 0-based index를 1-based 등수로 변환
    }
}
