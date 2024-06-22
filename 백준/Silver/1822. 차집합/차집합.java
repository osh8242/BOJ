import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] arrA = new int[A];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        Set<Integer> setB = new HashSet<Integer>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < A; i++) {
            boolean b = setB.add(arrA[i]);
            if (b) set.add(arrA[i]);
        }
        bw.write(String.valueOf(set.size()));
        bw.newLine();
        if (!set.isEmpty()) {
            for (Integer i : set) {
                bw.write(String.valueOf(i));
                bw.write(" ");
            }
        }
        bw.flush();
    }

}
