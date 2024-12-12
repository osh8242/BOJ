import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        while ((input = br.readLine()) != null) {
            int[] pos = new int[3];
            StringTokenizer st = new StringTokenizer(input);
            for (int i = 0; i < pos.length; i++) {
                pos[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(pos);
            sb.append(Math.max(pos[2] - pos[1], pos[1] - pos[0]) - 1).append("\n");
        }
        System.out.println(sb);
    }
}