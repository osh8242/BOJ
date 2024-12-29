import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        int Q = fr.nextInt();

        int[] freq = new int[1001];
        for(int i = 0; i < N; i++) {
            int num = fr.nextInt();
            freq[num]++;
        }

        int[] B = new int[N];
        int idx = 0;
        for(int num = 1; num <= 1000; num++) {
            while(freq[num] > 0 && idx < N) {
                B[idx++] = num;
                freq[num]--;
            }
        }

        long[] prefix = new long[N + 1];
        for(int i = 1; i <= N; i++) {
            prefix[i] = prefix[i-1] + B[i-1];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Q; i++) {
            int L = fr.nextInt();
            int R = fr.nextInt();
            long sum = prefix[R] - prefix[L-1];
            sb.append(sum).append('\n');
        }

        System.out.print(sb.toString());
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st == null || !st.hasMoreTokens()){
                try{
                    String line = br.readLine();
                    if(line == null) return null;
                    st = new StringTokenizer(line);
                } catch(IOException e){
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }
    }
}
