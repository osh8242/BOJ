import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder stringBuilder = new StringBuilder();
    static int[] digits;
    static int answer;

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            answer = 0;
            digits = new int[10];
            String line = br.readLine();
            for (int i = 0; i < line.length(); i++) {
                digits[line.charAt(i) - '0']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 9; i >= 0; i--) {
                if (digits[i] > 0) {
                    sb.append(String.valueOf(i).repeat(Math.max(0, digits[i])));
                }
            }

            for (int i = 1; i <= line.length(); i++) {
                dfs(i, "");
            }

            stringBuilder.append(answer).append("\n");
        }

        bw.write(stringBuilder.toString());
        bw.flush();
    }

    static void dfs(int length, String num) {
        if (num.length() == length) {
            if (isPrime(Integer.parseInt(num))) {
                answer++;
            }
            return;
        }
        for (int digit = 0; digit < 10; digit++) {
            if (digit == 0 && num.isEmpty()) continue;
            ;
            if (digits[digit] > 0) {
                digits[digit]--;
                dfs(length, num + digit);
                digits[digit]++;
            }
        }
    }

    static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        int sqrt = (int) Math.sqrt(num);
        for (int i = 3; i <= sqrt; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
