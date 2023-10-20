import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        char L = st.nextToken().charAt(0);
        int count = 0;
        int index = 1;
        int answer = Integer.MIN_VALUE;
        while (count < N) {
            String indexStr = String.valueOf(index);
            if (indexStr.indexOf(L) == -1) {
                count++;
                answer = index;
            }
            index++;
        }
        System.out.println(answer);
    }
}
