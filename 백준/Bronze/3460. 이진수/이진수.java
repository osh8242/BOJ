import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int num = Integer.parseInt(br.readLine());
            String binary = convertBinary(num);
            for (int i = 0; i < binary.length(); i++) {
                if (binary.charAt(i) == '1') sb.append(i + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static String convertBinary(int num) {
        String binary = "";
        while (num > 0) {
            binary += num % 2;
            num /= 2;
        }
        return binary;
    }
}
