import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int gcd = getGCD(nums[0], nums[1]);
        if (N == 3) gcd = getGCD(gcd, nums[2]);
        findCommonDivisor(gcd);
        System.out.println(sb);
    }

    static int getGCD(int a, int b) {
        if (b == 0) return a;
        else return getGCD(b, a % b);
    }

    static void findCommonDivisor(int num) {
        for (int i = 1; i <= num; i++)
            if (num % i == 0) sb.append(i).append("\n");
    }

}