import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double K = Double.parseDouble(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double D1 = Double.parseDouble(st.nextToken());
        double D2 = Double.parseDouble(st.nextToken());
        System.out.println(K * K - (D1 - D2) * (D1 - D2) / 4);
    }

}
