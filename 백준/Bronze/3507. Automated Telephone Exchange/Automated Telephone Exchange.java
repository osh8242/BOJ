import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < 10000; i++) {
            int firstPart = n;
            int secondPart = i / 100;
            int thirdPart = i % 100;
            if (firstPart - secondPart - thirdPart == 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}
