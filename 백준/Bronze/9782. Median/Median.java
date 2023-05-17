import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 1;
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n==0) break;
            int[] arr = new int[n+1];
            for(int i = 1 ; i <= n ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            sb.append("Case " + count + ": ");
            if(n%2==1) sb.append((double)arr[(n+1)/2]);
            else sb.append(((double)arr[n/2]+(double)arr[n/2+1])/2);
            sb.append("\n");
            count++;
        }
        System.out.println(sb);

    }//main

}//Class