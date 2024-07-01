import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int Z = Integer.parseInt(reader.readLine());
        int[] results = new int[Z];
        
        for (int i = 0; i < Z; i++) {
            String[] dimensions = reader.readLine().split(" ");
            int W = Integer.parseInt(dimensions[0]);
            int K = Integer.parseInt(dimensions[1]);
            
            results[i] = (W * K) / 2;
        }

        for (int result : results) {
            System.out.println(result);
        }
    }
}
