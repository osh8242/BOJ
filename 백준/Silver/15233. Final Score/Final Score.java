import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            set.add(st.nextToken());
        }

        br.readLine();

        int count = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < G; i++) {
            if (set.contains(st.nextToken())) count++;
            else count--;
        }

        bw.write(count > 0 ? "A" : count == 0 ? "TIE" : "B");
        bw.flush();
    }

}
