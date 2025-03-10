import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Character, Character> mirrorMap = new HashMap<>();
        mirrorMap.put('b', 'd');
        mirrorMap.put('d', 'b');
        mirrorMap.put('p', 'q');
        mirrorMap.put('q', 'p');
        mirrorMap.put('i', 'i');
        mirrorMap.put('o', 'o');
        mirrorMap.put('v', 'v');
        mirrorMap.put('w', 'w');
        mirrorMap.put('x', 'x');

        while (true) {
            String word = br.readLine();
            if (word.equals("#")) break;
            StringBuilder sb = new StringBuilder();
            boolean isValid = true;
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                if (mirrorMap.containsKey(ch)) {
                    sb.append(mirrorMap.get(ch));
                } else {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                bw.write(sb.toString() + "\n");
            } else {
                bw.write("INVALID\n");
            }
        }
        bw.flush();
    }
}
