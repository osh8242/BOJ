import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int answer = 0;
            answer += getZeroCount(Integer.parseInt(br.readLine()));
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static int getZeroCount(int num) {
        int result = 0;
        for (int i = 2; i <= num; i++) {
            int temp = num;
            while (true) {
                if (temp % i != 0) break;
                result++;
                temp /= i;
            }
        }
        return result;
    }

}