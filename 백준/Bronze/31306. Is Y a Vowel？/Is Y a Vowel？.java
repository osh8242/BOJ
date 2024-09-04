import java.io.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        int vowels = 0;
        int y = 0;
        for (char c : input.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vowels++;
            else if (c == 'y') y++;
        }
        sb.append(vowels).append(" ").append(vowels + y);
        bw.write(sb.toString());
        bw.flush();
    }

}
