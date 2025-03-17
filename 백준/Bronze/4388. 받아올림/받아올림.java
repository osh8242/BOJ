import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) continue;
            String[] parts = line.split(" ");
            if (parts.length < 2) continue;
            if (parts[0].equals("0") && parts[1].equals("0")) break;
            String a = parts[0];
            String b = parts[1];
            int i = a.length() - 1, j = b.length() - 1, carry = 0, count = 0;
            while (i >= 0 || j >= 0) {
                int digitA = (i >= 0) ? a.charAt(i) - '0' : 0;
                int digitB = (j >= 0) ? b.charAt(j) - '0' : 0;
                int sum = digitA + digitB + carry;
                if (sum >= 10) {
                    count++;
                    carry = 1;
                } else {
                    carry = 0;
                }
                i--;
                j--;
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}
