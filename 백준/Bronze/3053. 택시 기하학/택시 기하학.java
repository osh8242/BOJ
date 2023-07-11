import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static final double PI = Math.PI;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int r = Integer.parseInt(br.readLine());
        System.out.printf("%.6f\n%.6f", (double)r*r*PI, (double)r*r*2);

    }
}
