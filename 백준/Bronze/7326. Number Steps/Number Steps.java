import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            
            int result = -1;
            
            if (x == y) {
                result = 0;
                for (int j = 1; j <= x; j++) {
                    if (j % 2 == 1) {
                        result += 1;
                    } else {
                        result += 3;
                    }
                }
            } else if (y == x - 2 && x >= 2) {
                result = 2;
                for (int j = 3; j <= x; j++) {
                    if (j % 2 == 1) {
                        result += 1;
                    } else {
                        result += 3;
                    }
                }
            }
            
            if (result == -1) {
                sb.append("No Number\n");
            } else {
                sb.append(result).append("\n");
            }
        }
        
        System.out.print(sb.toString());
    }
}
