import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static final String GOD = "god";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            input[0] = GOD;
            StringBuilder temp = new StringBuilder();
            for(String word : input){
                temp.append(word);
            }
            sb.append(temp).append("\n");
        }
        System.out.println(sb);
    }
}
