import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int count = 0;
        while (n != 0 && m != 0) {
            if (n > m) {
                count += n / m;
                n = n % m;
            } else {
                count += m / n;
                m = m % n;
            }
        }

        System.out.println(count);
    }
}
