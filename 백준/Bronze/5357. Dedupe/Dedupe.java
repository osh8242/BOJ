import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String s = br.readLine();
            char prev = 'a';
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch != prev) {
                    bw.write(ch);
                    prev = ch;
                }
            }
            bw.newLine();
        }
        bw.flush();
    }

}