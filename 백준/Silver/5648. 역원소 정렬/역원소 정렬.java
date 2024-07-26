import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        List<Long> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long num = sc.nextLong();
            list.add(getReverseLong(num));
        }

        Collections.sort(list);
        for (Long l : list) sb.append(l).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    static long getReverseLong(long num) {
        long reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }

}
