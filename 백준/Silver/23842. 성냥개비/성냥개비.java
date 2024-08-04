import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    // 각 숫자가 필요한 성냥개비 수를 배열로 저장
    private static final int[] MATCHES = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        
        // 총 필요한 성냥개비의 수를 계산
        int requiredMatches = N - 4; // +와 = 각각 2개의 성냥개비 사용
        if (requiredMatches < 0) {
            bw.write("impossible\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        boolean found = false;

        // 두 자리 숫자 00부터 99까지 순회
        for (int i = 0; i <= 99 && !found; i++) {
            for (int j = 0; j <= 99 && !found; j++) {
                int k = i + j;
                if (k > 99) continue; // 결과가 두 자리 숫자가 아닌 경우

                // 각 숫자에 필요한 성냥개비 수를 계산
                int totalMatches = getMatchCount(i) + getMatchCount(j) + getMatchCount(k);

                if (totalMatches == requiredMatches) {
                    bw.write(String.format("%02d+%02d=%02d\n", i, j, k));
                    found = true;
                }
            }
        }

        if (!found) {
            bw.write("impossible\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 숫자에 필요한 성냥개비 수를 계산하는 함수
    private static int getMatchCount(int num) {
        return MATCHES[num / 10] + MATCHES[num % 10];
    }
}
