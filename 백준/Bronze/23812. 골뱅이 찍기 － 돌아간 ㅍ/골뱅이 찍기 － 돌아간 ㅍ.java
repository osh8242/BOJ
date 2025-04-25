import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int bigRow = 0; bigRow < 5; bigRow++) {
            for (int smallRow = 0; smallRow < N; smallRow++) {
                for (int bigCol = 0; bigCol < 5; bigCol++) {
                    boolean fill;
                    if (bigRow % 2 == 1) {
                        fill = true;
                    } else {
                        fill = (bigCol == 0 || bigCol == 4);
                    }
                    for (int k = 0; k < N; k++) {
                        sb.append(fill ? '@' : ' ');
                    }
                }
                sb.append('\n');
            }
        }
        
        System.out.print(sb);
    }
}
