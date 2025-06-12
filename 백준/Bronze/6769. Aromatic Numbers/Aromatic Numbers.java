import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        int n = s.length() / 2;
        int[] A = new int[n];
        int[] R = new int[n];
        Map<Character,Integer> m = new HashMap<>();
        m.put('I',1); m.put('V',5); m.put('X',10); m.put('L',50);
        m.put('C',100); m.put('D',500); m.put('M',1000);
        for (int i = 0; i < n; i++) {
            A[i] = s.charAt(2*i) - '0';
            R[i] = m.get(s.charAt(2*i+1));
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            int v = A[i] * R[i];
            if (i < n-1 && R[i] < R[i+1]) total -= v;
            else total += v;
        }
        System.out.println(total);
    }
}
