import java.io.*;
import java.util.*;

public class Main {
    public static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n==1) {
            System.out.println(0);
            return;
        }
        if (n == 2 || n == 3) {
            System.out.println(1);
        } else {
            answer = new int[n+1];
            answer[2] = 1;
            answer[3] = 1;
            for (int i = 4 ; i <= n ; i++){
                switch (i%6){
                    case 1:
                    case 5: answer[i] = answer[i-1]+1; break;
                    case 2:
                    case 4: answer[i] = Math.min(answer[i/2],answer[i-1])+1; break;
                    case 3: answer[i] = Math.min(answer[i/3],answer[i-1])+1; break;
                    default: answer[i] = Math.min(answer[i/3],Math.min(answer[i/2],answer[i-1]))+1;
                }
            }
            System.out.println(answer[n]);
        }
    }
}
