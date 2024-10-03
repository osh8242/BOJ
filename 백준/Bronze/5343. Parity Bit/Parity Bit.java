import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int answer = 0;
            int idx = 0;
            String input = br.readLine();
            int N = input.length() / 8;
            while (N-- > 0) {
                int count = 0;
                for (int i = idx; i < idx + 7; i++) {
                    if (input.charAt(i) == '1') count++;
                }
                if ((isOdd(count) && input.charAt(idx + 7) == '0') || (!isOdd(count) && input.charAt(idx + 7) == '1'))
                    answer++;
                idx += 8;
            }
            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static boolean isOdd(int count) {
        return count % 2 == 1;
    }

}
