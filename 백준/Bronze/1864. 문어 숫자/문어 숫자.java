import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('-', 0);
        hm.put('\\', 1);
        hm.put('(', 2);
        hm.put('@', 3);
        hm.put('?', 4);
        hm.put('>', 5);
        hm.put('&', 6);
        hm.put('%', 7);
        hm.put('/', -1);

        String line = "";
        while (!(line = br.readLine()).equals("#")) {
            int index = line.length() - 1;
            int answer = 0;
            for (int i = 0; i < line.length(); i++) {
                answer += hm.get(line.charAt(i)) * (int) Math.pow(8, index--);
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}