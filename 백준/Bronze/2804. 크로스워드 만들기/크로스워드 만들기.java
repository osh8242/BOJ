import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        char[] A = inputs[0].toCharArray();
        char[] B = inputs[1].toCharArray();

        // 교차점 찾기
        int row = -1;
        int col = -1;
        outer:
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    row = j;
                    col = i;
                    break outer;
                }
            }
        }

        // 출력문 작성
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < B.length; i++) {
            if (i != row) {
                for (int j = 0; j < A.length; j++) {
                    if (j != col) sb.append('.');
                    else sb.append(B[i]);
                }
            } else {
                sb.append(A);
            }
            sb.append("\n");
        }

        // 정답 출력
        System.out.println(sb);
    }

}