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
            int t = Integer.parseInt(input);
            Set<Integer> set = new HashSet<>();
            String range = br.readLine();
            String[] pages = range.split(",");
            for (String page : pages) {
                if (!page.contains("-")) {
                    int p = Integer.parseInt(page);
                    if (p <= t) set.add(p);
                } else {
                    String[] split = page.split("-");
                    int start = Integer.parseInt(split[0]);
                    int end = Integer.parseInt(split[1]);
                    if (start > end) continue;
                    for (int i = start; i <= end; i++) {
                        if (i <= t) set.add(i);
                    }
                }
            }
            sb.append(set.size()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
