import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = 0;
        int[] coins = new int[n];
        for (int i = n-1 ; i >= 0 ; i--){
            coins[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0 ; i < n ; i++){
            answer += k/coins[i];
            k %= coins[i];
        }
        System.out.println(answer);
    }
}