import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder output = new StringBuilder();
        while ((line = br.readLine()) != null) {
            if (line.isEmpty()) {
                output.append("\n");
                continue;
            }
            String[] words = line.split(" ");
            ArrayList<String> vowels = new ArrayList<>();
            for (String w : words) {
                char c = Character.toLowerCase(w.charAt(0));
                if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u') {
                    vowels.add(w);
                }
            }
            int vidx = vowels.size() - 1;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                String w = words[i];
                char c = Character.toLowerCase(w.charAt(0));
                if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u') {
                    sb.append(vowels.get(vidx--));
                } else {
                    sb.append(w);
                }
                if (i < words.length - 1) sb.append(' ');
            }
            output.append(sb).append('\n');
        }
        System.out.print(output);
    }
}
