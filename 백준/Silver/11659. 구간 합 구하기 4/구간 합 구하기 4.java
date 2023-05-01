import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] nums = new int[n+1];
        int[] sums = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
            sums[i] += num+sums[i-1];
        }
        for(int line = 1 ; line <= m ; line++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(sums[end]-sums[start-1]+"\n");
        }
        System.out.println(sb.toString());
    }
}
