import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] names = new String[N];
        for (int i = 0; i < N; i++) {
            names[i] = br.readLine();
        }
        
        boolean isAsc = true;
        boolean isDesc = true;
        
        for (int i = 1; i < N; i++) {
            if (names[i].compareTo(names[i-1]) < 0) {
                isAsc = false;
            }
            if (names[i].compareTo(names[i-1]) > 0) {
                isDesc = false;
            }
            if (!isAsc && !isDesc) {
                break;
            }
        }
        
        if (isAsc) {
            System.out.println("INCREASING");
        } else if (isDesc) {
            System.out.println("DECREASING");
        } else {
            System.out.println("NEITHER");
        }
    }
}
