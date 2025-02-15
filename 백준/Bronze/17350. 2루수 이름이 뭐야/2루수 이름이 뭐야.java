import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("뭐야");
        int N = Integer.parseInt(br.readLine());
        boolean found = false;
        while (N-- > 0) {
            String name = br.readLine();
            if (name.equals("anj")) {
                sb.append(";");
                found = true;
                break;
            }
        }
        if (!found) sb.append("?");
        System.out.println(sb);
    }

}
