import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] cnt = new int[100001];
        int left = 0;
        int ans = 0;

        for (int right = 0; right < N; right++) {
            cnt[arr[right]]++;
            while (cnt[arr[right]] > K) {
                cnt[arr[left]]--;
                left++;
            }
            int len = right - left + 1;
            if (len > ans) ans = len;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ans);
        System.out.print(sb.toString());
    }
}
