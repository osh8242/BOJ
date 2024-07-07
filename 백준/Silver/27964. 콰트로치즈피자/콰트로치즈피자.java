import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean isPossible = false;
        while (st.hasMoreTokens()) {
            String topping = st.nextToken();
            if(topping.endsWith("Cheese")) set.add(topping);
            if(set.size() == 4) {
                isPossible = true;
                break;
            }
        }

        bw.write(isPossible ? "yummy" : "sad");
        bw.flush();
    }
}
