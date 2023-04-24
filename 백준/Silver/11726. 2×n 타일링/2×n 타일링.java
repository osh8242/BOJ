import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n==1) {
            System.out.println(1);
            return;
        }
        if(n==2) {
            System.out.println(2);
            return;
        }
        int[] answer = new int[n+1];
        answer[1] = 1;
        answer[2] = 2;
        for(int i = 3 ; i <= n ; i++){
            answer[i] = answer[i-1]+answer[i-2];
            if (answer[i] > 10007) answer[i] %= 10007;
        }
        System.out.println(answer[n]);
    }
}
