import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input;
        while (!(input = br.readLine()).equals("0")) {
            Set<Integer> set = new HashSet<>();
            int current = Integer.parseInt(input);
            while (set.add(current)) {
                int temp = current * current;
                StringBuilder tempSb = new StringBuilder(Integer.toString(temp));
                while (tempSb.length() < 8) {
                    tempSb.insert(0, "0");
                }
                current = Integer.parseInt(tempSb.substring(2, 6));
            }
            sb.append(set.size()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

}
