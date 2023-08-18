import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] a = st.nextToken().toCharArray();
        char[] b = st.nextToken().toCharArray();
        sb.append(
            (getValue(a, '6', '5') + getValue(b, '6', '5'))
            + " " +
            (getValue(a, '5', '6') + getValue(b, '5', '6'))
        );
        System.out.println(sb);
    }

    static int getValue(char[] chars, char from, char to) {
        int answer = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == from) chars[i] = to;
        }
        answer = Integer.parseInt(new String(chars));
        return answer;
    }

}
