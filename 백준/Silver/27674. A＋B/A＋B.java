import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            br.readLine();
            char[] input = br.readLine().toCharArray();
            int idx = -1;
            int min = Integer.MAX_VALUE;

            // 최소값 찾는 과정 수정: char -> int 변환 후 비교
            for (int i = 0; i < input.length; i++) {
                int digit = input[i] - '0';
                if (digit < min) {
                    min = digit;
                    idx = i;
                }
            }

            // 최소값 제외 후 내림차순 정렬
            Character[] maxChars = new Character[input.length - 1];
            int index = 0;
            for (int i = 0; i < input.length; i++) {
                if (i != idx) {
                    maxChars[index++] = input[i];
                }
            }
            Arrays.sort(maxChars, Collections.reverseOrder());

            StringBuilder maxNumberStr = new StringBuilder();
            for (char c : maxChars) {
                maxNumberStr.append(c);
            }

            long maxNumber = Long.parseLong(maxNumberStr.toString());
            long sum = maxNumber + min;
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
