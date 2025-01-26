import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static long a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        if (a == 1 && b == 1) {
            System.out.println("0 0");
            return;
        }

        long l = 0;
        long r = 0;

        while (!(a == 1 && b == 1)) {
            if (a > b) {
                if (b == 1) {
                    l += (a - b);
                    a = 1;
                } else {
                    long div = a / b;
                    l += div;
                    a -= (div * b);
                }
            } else {
                if (a == 1) {
                    r += (b - a);
                    b = 1;
                } else {
                    long div = b / a;
                    r += div;
                    b -= (div * a);
                }
            }
        }

        System.out.println(l + " " + r);
    }
}
