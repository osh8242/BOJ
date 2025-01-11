import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] pocket = new int[n+1];
        for (int i = 1 ; i <= n ; i++){
            pocket[i] = i;
        }
        for (int i = 1 ; i <= m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] temp = new int[b-a+1];
            for (int j = 0 ; j < b-a+1 ; j++){
                temp[j] = pocket[b-j];
            }
            for(int j = a ; j <= b ; j++){
                pocket[j] = temp[j-a];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1 ; i <= n ; i++ ){
            sb.append(pocket[i]).append(" ");
        }
        System.out.println(sb);
    }
}