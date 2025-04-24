import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ops = br.readLine().trim();
        
        int smallPos = 1;  // 작은 공 위치
        int bigPos = 4;    // 큰 공 위치
        
        for (char op : ops.toCharArray()) {
            int x = 0, y = 0;
            switch (op) {
                case 'A': x = 1; y = 2; break;
                case 'B': x = 1; y = 3; break;
                case 'C': x = 1; y = 4; break;
                case 'D': x = 2; y = 3; break;
                case 'E': x = 2; y = 4; break;
                case 'F': x = 3; y = 4; break;
            }
            if (smallPos == x) smallPos = y;
            else if (smallPos == y) smallPos = x;
            
            if (bigPos == x) bigPos = y;
            else if (bigPos == y) bigPos = x;
        }
        
        System.out.println(smallPos);
        System.out.println(bigPos);
    }
}
