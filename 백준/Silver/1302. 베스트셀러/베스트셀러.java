import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> map = new TreeMap<>();
        String answer = "";
        int maxCount = 0;
        while (N-- > 0) {
            String book = br.readLine();
            int count = map.getOrDefault(book, 0) + 1;
            map.put(book, count);
            if (count > maxCount) {
                maxCount = count;
                answer = book;
            } else if (count == maxCount && book.compareTo(answer) < 0) {
                answer = book;
            }
        }
        System.out.println(answer);
    }

}
