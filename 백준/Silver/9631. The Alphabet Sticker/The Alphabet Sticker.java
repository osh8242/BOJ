import java.io.*;

public class Main {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String s = br.readLine();
            long result = 1;
            int n = s.length();

            for (int i = 0; i < n; ) {
                if (s.charAt(i) == '?') {
                    int j = i;
                    while (j < n && s.charAt(j) == '?') {
                        j++;
                    }

                    char left = i > 0 ? s.charAt(i - 1) : 0;
                    char right = j < n ? s.charAt(j) : 0;

                    if (left != 0 && right != 0) {
                        if (left != right) {
                            result *= (j - i + 1);
                        }
                    }
                    result %= MOD;
                    i = j;
                } else {
                    i++;
                }
            }

            sb.append(result).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
