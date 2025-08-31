import java.io.*;
public class Main {
    static int countBinary(int n, int target) {
        int left = 0, right = n - 1;
        int cnt = 0;
        while (true) {
            int mid = (left + right) >>> 1;
            if (mid == target) return cnt;
            cnt++;
            if (target < mid) right = mid - 1;
            else left = mid + 1;
        }
    }

    static int countTernary(int n, int target) {
        int left = 0, right = n - 1;
        int cnt = 0;
        while (true) {
            int third = (right - left) / 3;
            int left_third = left + third;
            int right_third = right - third;
            if (left_third == target) return cnt;
            cnt++;
            if (right_third == target) return cnt;
            cnt++;
            if (target < left_third) {
                right = left_third - 1;
            } else if (target < right_third) {
                left = left_third + 1;
                right = right_third - 1;
            } else {
                left = right_third + 1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        long less = 0, equal = 0, greater = 0;
        for (int i = 0; i < N; i++) {
            int b = countBinary(N, i);
            int t = countTernary(N, i);
            if (b < t) less++;
            else if (b == t) equal++;
            else greater++;
        }
        StringBuilder sb = new StringBuilder(64);
        sb.append(less).append('\n');
        sb.append(equal).append('\n');
        sb.append(greater).append('\n');
        System.out.print(sb.toString());
    }
}
