import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), "-");
            String str = st.nextToken();
            int strNum = parseStr(str);
            int num = Integer.parseInt(st.nextToken());
            sb.append(Math.abs(num - strNum) <= 100 ? "nice" : "not nice").append("\n");
        }
        System.out.println(sb);
    }

    static int parseStr(String str) {
        int answer = 0;
        for (int i = 2; i >= 0; i--) {
            answer += (int) Math.pow(26, i) * (str.charAt(2 - i) - 65);
        }
        return answer;
    }
}
