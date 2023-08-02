import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> personNum = new ArrayList<>();
        while (st.hasMoreTokens()) {
            int persons = Integer.parseInt(st.nextToken());
            personNum.add(persons);
        }
        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long sum = 0;
        for (Integer persons : personNum) {
            persons -= b;
            sum++;
            if (persons > 0) {
                sum += persons / c;
                if (persons % c != 0) sum++;
            }
        }
        System.out.println(sum);

    }
}
