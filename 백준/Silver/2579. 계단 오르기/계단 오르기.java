import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] steps = new int[n+1];
        for (int i = 1 ; i <= n ; i++){
            steps[i] = Integer.parseInt(br.readLine());
        }
        int[] answer = new int[n+1];
        answer[1] = steps[1];
        if(n>=2) answer[2] = steps[1]+steps[2];
        if(n>=3){
            answer[3] = Math.max(steps[1] + steps[3], steps[2] + steps[3]);
            for(int i = 4 ; i <= n ; i++) {
                answer[i] = Math.max(answer[i-3] + steps[i-1] + steps[i], answer[i-2] + steps[i]);
            }
        }
        System.out.println(answer[n]);
    }
}