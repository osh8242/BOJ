import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            br.readLine();
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            int maxPower = -1;
            char winner = 'S';
            input = br.readLine().split(" ");
            for (String s : input) {
                int power = Integer.parseInt(s);
                maxPower = Math.max(power, maxPower);
            }
            input = br.readLine().split(" ");
            for (String s : input) {
                int power = Integer.parseInt(s);
                if (power > maxPower) {
                    winner = 'B';
                    break;
                }
            }
            sb.append(winner).append("\n");
        }
        System.out.println(sb);
    }
}