import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        String line;
        while (!(line = br.readLine()).equals("#")) {
            for (int i = 0; i < line.length(); i++) {
                if (set.contains(line.charAt(i))) {
                    bw.write(line.substring(i));
                    bw.write(line.substring(0, i));
                    bw.write("ay");
                    bw.newLine();
                    break;
                }
                if (i == line.length() - 1) {
                    bw.write(line);
                    bw.write("ay");
                    bw.newLine();
                }
            }
        }
        bw.flush();
    }

}
