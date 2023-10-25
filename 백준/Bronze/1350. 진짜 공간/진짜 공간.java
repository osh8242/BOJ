import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, cluster;
    static int[] files;
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        files = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) files[i] = Integer.parseInt(st.nextToken());
        cluster = Integer.parseInt(br.readLine());
        for (int fileSize : files) calculateSize(fileSize);
        System.out.println(answer);
    }

    static void calculateSize(int fileSize) {
        if (fileSize == 0) return;
        answer += (fileSize / cluster) * cluster;
        if (fileSize % cluster != 0) answer += cluster;
    }

}
