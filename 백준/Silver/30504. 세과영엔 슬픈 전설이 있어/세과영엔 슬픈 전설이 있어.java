import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Payment[] a = getPayments(br, N);
        Payment[] b = getPayments(br, N);
        Arrays.sort(a);
        Arrays.sort(b);

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            if (a[i].money <= b[i].money) answer[a[i].index] = b[i].money;
            else {
                System.out.println(-1);
                return;
            }
        }
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    static Payment[] getPayments(BufferedReader br, int N) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        Payment[] a = new Payment[N];
        for (int i = 0; i < N; i++) {
            a[i] = new Payment(i, Integer.parseInt(st.nextToken()));
        }
        return a;
    }

}

class Payment implements Comparable<Payment> {
    int index;
    int money;

    public Payment(int index, int money) {
        this.index = index;
        this.money = money;
    }

    @Override
    public int compareTo(Payment o) {
        return money - o.money;
    }
}
