import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class Main {
    static Function<Character, Character>[] functions;

    static {
        functions = new Function[4];
        functions[0] = ch -> ch == 'E' ? 'I' : 'E';
        functions[1] = ch -> ch == 'S' ? 'N' : 'S';
        functions[2] = ch -> ch == 'T' ? 'F' : 'T';
        functions[3] = ch -> ch == 'J' ? 'P' : 'J';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] mbti = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(functions[i].apply(mbti[i]));
        }
        System.out.println(sb);
    }
}
