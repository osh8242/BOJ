import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        
        int[] maxPrimeFactor = new int[N + 1];
        
        for (int i = 2; i <= N; i++) {
            if (maxPrimeFactor[i] == 0) {
                for (int j = i; j <= N; j += i) {
                    maxPrimeFactor[j] = i;
                }
            }
        }
        
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (maxPrimeFactor[i] <= K) {
                count++;
            }
        }
        
        sb.append(count);
        System.out.print(sb.toString());
    }
}
