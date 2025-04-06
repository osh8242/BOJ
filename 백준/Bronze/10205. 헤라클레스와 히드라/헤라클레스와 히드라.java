import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int K = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= K; i++) {
            int heads = Integer.parseInt(br.readLine());
            String actions = br.readLine();
            
            for (char act : actions.toCharArray()) {
                if (heads == 0) break;
                
                if (act == 'c') {
                    heads++;
                } else if (act == 'b') {
                    heads--;
                }
            }
            
            sb.append("Data Set ").append(i).append(":\n");
            sb.append(heads).append("\n");
            if (i != K) {
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
