import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= N ; i++){
            sb.append("Hello World, Judge ").append(i).append("!").append("\n");
        }
        System.out.println(sb);
    }
}
