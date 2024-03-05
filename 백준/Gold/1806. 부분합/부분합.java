import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] sums = new int[N + 1];
        for(int i = 1 ; i <= N ; i++){
            sums[i] = sums[i-1] + Integer.parseInt(st.nextToken());
        }
        int left = 1;
        int right = 1;
        int minLength = N+1;
        while(left <= N && right <= N){
            int sum = sums[right]-sums[left-1];
            if(sum >= S) {
                if(right == left) {
                    minLength = 1; break;
                }
                minLength = Math.min(right - left++ + 1, minLength);
            } else  right++;
        }
        System.out.println(minLength == N+1 ? 0 : minLength);
    }
}