import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char num = br.readLine().charAt(0);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        while (st.hasMoreTokens()) {
            char ch = st.nextToken().charAt(0);
            if (num==ch) answer++;
        }
        System.out.println(answer);
    }
}
