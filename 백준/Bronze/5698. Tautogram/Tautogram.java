import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input;
        while (!(input = br.readLine()).equals("*")) {
            String[] words = input.split(" ");
            boolean isTautogram = true;
            char ch = Character.toLowerCase(words[0].charAt(0));
            for (int i = 1; i < words.length; i++) {
                char temp = Character.toLowerCase(words[i].charAt(0));
                if (ch != temp) {
                    isTautogram = false;
                    break;
                }
            }
            sb.append(isTautogram ? 'Y' : 'N').append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
