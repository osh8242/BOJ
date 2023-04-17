import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] ball = new int[n+1];
        for (int i = 1 ; i <= n ; i++){
            ball[i] = i;
        }
        for (int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int temp = ball[a];
            ball[a] = ball[b];
            ball[b] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i < n ; i++){
            sb.append(ball[i]+" ");
        }
        System.out.println(sb.append(ball[n]).toString());
    }

}