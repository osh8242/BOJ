import java.io.*;
import java.util.*;

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
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            boolean b = setB.add(arrA[i]);
            if (b) list.add(arrA[i]);
        }
        bw.write(String.valueOf(list.size()));
        bw.newLine();
        if (!list.isEmpty()) {
            Collections.sort(list);
            for (Integer i : list) {
                bw.write(String.valueOf(i));
                bw.write(" ");
            }
        }
        bw.flush();
    }

}
