import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String num1 = st.nextToken();
        String num2 = st.nextToken();
        long answer = 0;
        for (int i = 0; i < num1.length(); i++) {
            int a = Character.getNumericValue(num1.charAt(i));
            for (int j = 0; j < num2.length(); j++) {
                int b = Character.getNumericValue(num2.charAt(j));
                answer += a * b;
            }
        }
        System.out.println(answer);
    }
}
