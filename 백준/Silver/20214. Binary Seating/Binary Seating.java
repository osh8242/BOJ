import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(st.nextToken());
            freq.put(t, freq.getOrDefault(t, 0) + 1);
        }
        List<Integer> times = new ArrayList<>(freq.keySet());
        Collections.sort(times, Collections.reverseOrder());
        double expected = 0.0;
        double pNone = 1.0;
        for (int tval : times) {
            int c = freq.get(tval);
            double pAtLeastOne = 1.0 - Math.pow(0.5, c);
            double pMaxHere = pNone * pAtLeastOne;
            expected += pMaxHere * tval;
            pNone *= Math.pow(0.5, c);
        }
        System.out.printf("%.10f\n", expected);
    }
}
