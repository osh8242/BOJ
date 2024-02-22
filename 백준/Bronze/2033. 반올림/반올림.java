import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        // 각 자릿수 ArrayList
        List<Integer> digits = new ArrayList<>(2 * input.length);
        for (int i = input.length - 1; i >= 0; i--) {
            digits.add(input[i] - '0');
        }

        // 1의 자리수부터 반올림시작
        for (int i = 0; i < input.length - 1; i++) {
            if (digits.get(i) >= 5) {
                digits.set(i + 1, digits.get(i + 1) + 1);
            }
            digits.set(i, 0);
        }

        // 정답출력
        StringBuilder sb = new StringBuilder();
        for (int i = digits.size() - 1; i >= 0; i--) {
            sb.append(digits.get(i));
        }
        System.out.println(sb);
    }
}