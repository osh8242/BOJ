import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] token = new int[]{25,10,5,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int c = 1 ; c <= T ; c++){
            int change = Integer.parseInt(br.readLine());
            for(int i = 0 ; i < 4 ; i++){
                sb.append(change/token[i] + " ");
                change %= token[i];
            }
            sb.append("\n");

        }
        System.out.println(sb.toString());

    }

}
