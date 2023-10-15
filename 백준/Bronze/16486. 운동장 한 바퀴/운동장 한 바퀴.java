import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static final double PI = Math.PI;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int width = Integer.parseInt(br.readLine());
        int radius = Integer.parseInt(br.readLine());
        System.out.println(2 * radius * PI + 2 * width);
    }
}
