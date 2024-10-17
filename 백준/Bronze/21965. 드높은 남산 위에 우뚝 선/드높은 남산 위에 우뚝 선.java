import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        boolean isAsc = true;
        boolean isMountain = true;
        for (int i = 1; i < N && isMountain; i++) {
            int current = Integer.parseInt(st.nextToken());
            if (prev == current) isMountain = false;
            else if (isAsc && prev > current) isAsc = false;
            else if (!isAsc && prev < current) isMountain = false;
            prev = current;
        }
        System.out.println(isMountain ? "YES" : "NO");
    }

}

