import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static Map<Character, String> code = new HashMap<>();

    static {
        code.put(' ', "%20");
        code.put('!', "%21");
        code.put('$', "%24");
        code.put('%', "%25");
        code.put('(', "%28");
        code.put(')', "%29");
        code.put('*', "%2a");
    }

    public static void main(String[] args) throws IOException {
        String s;
        while (!(s = br.readLine()).equals("#")) {
            for (char c : s.toCharArray()) {
                if (code.containsKey(c)) {
                    sb.append(code.get(c));
                } else {
                    sb.append(c);
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
