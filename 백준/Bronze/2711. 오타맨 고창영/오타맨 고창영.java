import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken())-1;
            char[] wrongWord = st.nextToken().toCharArray();
            for (int i = 0; i < wrongWord.length; i++) {
                if (i != index) sb.append(wrongWord[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
