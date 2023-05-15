import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int test = 1 ; test <= t ; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long result = 1;
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int divisor = 1;
            for (int i = m-n+1 ; i <= m ; i++) {
                result *= i;
                if(result%divisor==0 & divisor <= n){
                    result /= divisor;
                    divisor++;
                }
            }
            for( ; divisor <= n ; divisor++){
                result /= divisor;
            }
            sb.append(result+"\n");
        }
        System.out.println(sb);

    }

}
