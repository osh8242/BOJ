import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        boolean a = A % 2 == 1;
        boolean b = B % 2 == 1;
        boolean c = C % 2 == 1;
        if ((a && b && c) || (!a && !b && !c)) System.out.println(A * B * C);
        else {
            int result = 1;
            if (a) result *= A;
            if (b) result *= B;
            if (c) result *= C;
            System.out.println(result);
        }
    }

}
