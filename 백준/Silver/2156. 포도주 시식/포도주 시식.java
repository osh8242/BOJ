import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] record = new int[n+1];
        record[1] = Integer.parseInt(br.readLine());
        if(n==1) {
            System.out.println(record[1]);
            return;
        }
        record[2] = Integer.parseInt(br.readLine());
        int[] dp = record.clone();
        dp[2] += record[1];
        for(int i = 3 ; i <= n ; i++){
            int quantity = Integer.parseInt(br.readLine());
            record[i] = quantity;
            dp[i] = Math.max(Math.max(dp[i-3]+record[i-1]+record[i], dp[i-2] + record[i]),dp[i-1]);
        }
        System.out.println(dp[n]);
    }

}
