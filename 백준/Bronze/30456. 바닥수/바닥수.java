import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        StringBuilder result = getResult(N, L);

        bw.write(result.toString());
        bw.flush();
    }

    private static StringBuilder getResult(int N, int L) {
        StringBuilder result = new StringBuilder();
        for(int i = 1 ; i < L ; i++ ) result.append("1");
        result.append(N);
        return result;
    }
}
