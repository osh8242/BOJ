import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        final int MOD = 20000303;
        
        String N = br.readLine();
        
        int remainder = 0;
        for (int i = 0; i < N.length(); i++) {
            int digit = N.charAt(i) - '0';
            remainder = (remainder * 10 + digit) % MOD;
        }
        
        bw.write(remainder + "\n");
        bw.flush();
    }
}
