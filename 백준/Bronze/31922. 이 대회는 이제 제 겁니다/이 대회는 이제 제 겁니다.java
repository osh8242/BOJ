import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sp = br.readLine().split(" ");
        int A = Integer.parseInt(sp[0]);
        int P = Integer.parseInt(sp[1]);
        int C = Integer.parseInt(sp[2]);
        int ans = Math.max(A + C, P);
        System.out.print(ans);
    }
}
