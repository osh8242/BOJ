import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String[] line = br.readLine().split(" ");
            int age = Integer.parseInt(line[0]);
            if (age == 0) break;
            int leaves = 1;
            for (int i = 1; i <= 2 * age; i += 2) {
                int factor = Integer.parseInt(line[i]);
                int cutCount = Integer.parseInt(line[i + 1]);
                leaves = leaves * factor - cutCount;
            }
            sb.append(leaves).append("\n");
        }
        System.out.println(sb);
    }
}