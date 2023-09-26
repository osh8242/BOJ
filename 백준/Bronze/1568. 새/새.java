import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        while (n > 0) {
            int k = 1;
            while (n >= k) {
                n -= k++;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
