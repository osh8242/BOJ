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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int GCD = a > b ? getGCD(a, b) : getGCD(b, a);
            sb.append(a * b / GCD).append(" ").append(GCD).append("\n");
        }
        System.out.println(sb);
    }

    static int getGCD(int a, int b) {
        if (b == 0)
            return a;
        else
            return getGCD(b, a % b);
    }
}