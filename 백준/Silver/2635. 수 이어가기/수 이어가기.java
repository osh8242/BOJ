import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 1; i <= N; i++) {
            int count = getCount(N, i);
            if (count > max) {
                max = count;
                maxIndex = i;
            }
        }
        List<Integer> list = getList(N, maxIndex);
        sb.append(max).append("\n");
        for (int i = 0; i < max; i++) {
            sb.append(list.get(i)).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static int getCount(int N, int i) {
        int count = 2;
        int first = N;
        int second = i;
        while (first >= second) {
            int temp = first - second;
            first = second;
            second = temp;
            count++;
        }
        return count;
    }

    static List<Integer> getList(int N, int i) {
        List<Integer> list = new ArrayList<>();
        list.add(N);
        list.add(i);
        int first = N;
        int second = i;
        while (first >= second) {
            int temp = first - second;
            list.add(temp);
            first = second;
            second = temp;
        }
        return list;
    }
}
