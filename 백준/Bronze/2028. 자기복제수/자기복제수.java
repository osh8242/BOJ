import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            String line = br.readLine();
            int num = Integer.parseInt(line);
            int square = num * num;
            sb.append(num == square % (int) Math.pow(10, line.length()) ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }
}