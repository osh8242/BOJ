import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int startYear = Integer.parseInt(reader.readLine().trim());
        int endYear = Integer.parseInt(reader.readLine().trim());

        int lcm = lcm(4, lcm(2, lcm(3, 5))); // LCM of 4, 2, 3, and 5

        StringBuilder output = new StringBuilder();
        for (int year = startYear; year <= endYear; year++) {
            if ((year - startYear) % lcm == 0) {
                output.append("All positions change in year ").append(year).append("\n");
            }
        }

        System.out.print(output.toString());
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}
