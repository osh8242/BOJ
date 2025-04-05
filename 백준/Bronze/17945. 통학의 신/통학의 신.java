import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int disc = A * A - B;
        int sqrtDisc = (int)Math.sqrt(disc);
        int r1 = -A - sqrtDisc;
        int r2 = -A + sqrtDisc;
        if(r1 == r2) {
            System.out.println(r1);
        } else {
            int[] roots = {r1, r2};
            Arrays.sort(roots);
            System.out.println(roots[0] + " " + roots[1]);
        }
    }
}
