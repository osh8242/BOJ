import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        String[] powerStrings = br.readLine().split(" ");
        int[] fi = new int[n];
        long totalSum = 0;
        
        for (int i = 0; i < n; i++) {
            fi[i] = Integer.parseInt(powerStrings[i]);
            totalSum += fi[i];
        }
        
        for (int i = 0; i < n; i++) {
            if (fi[i] == totalSum - fi[i]) {
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sb.append(fi[j]).append(" ");
                    }
                }
                sb.append(fi[i]);
                bw.write(sb.toString());
                bw.flush();
                bw.close();
                br.close();
                return;
            }
        }
    }
}
