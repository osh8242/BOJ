import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main {
    static final int BUF_SIZE = 1 << 16;
    static byte[] buffer = new byte[BUF_SIZE];
    static int bId = 0, bSize = 0;
    static InputStream in = System.in;

    static byte read() throws IOException {
        if (bId == bSize) {
            bSize = in.read(buffer, 0, BUF_SIZE);
            bId = 0;
            if (bSize == -1) buffer[0] = -1;
        }
        return buffer[bId++];
    }

    static boolean isSpace(byte c) { return c <= ' '; }

    static int nextInt() throws IOException {
        int c = read();
        while (isSpace((byte)c)) c = read();
        boolean neg = c == '-';
        if (neg) c = read();
        int val = 0;
        while (!isSpace((byte)c) && c != -1) {
            val = val * 10 + (c - '0');
            c = read();
        }
        return neg ? -val : val;
    }

    static double nextDouble() throws IOException {
        int c = read();
        while (isSpace((byte)c)) c = read();
        boolean neg = c == '-';
        if (neg) c = read();
        double val = 0.0;
        while ((c >= '0' && c <= '9')) {
            val = val * 10 + (c - '0');
            c = read();
        }
        if (c == '.') {
            double fraction = 1;
            c = read();
            while (c >= '0' && c <= '9') {
                fraction /= 10;
                val += (c - '0') * fraction;
                c = read();
            }
        }
        if (neg) val = -val;
        while (!isSpace((byte)c) && c != -1) c = read();
        return val;
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int nx = nextInt();
            int ny = nextInt();
            double w = nextDouble();
            if (nx == 0 && ny == 0 && w == 0.0) break;

            double[] nxArr = new double[nx];
            for (int i = 0; i < nx; i++) {
                nxArr[i] = nextDouble();
            }

            double[] nyArr = new double[ny];
            for (int i = 0; i < ny; i++) {
                nyArr[i] = nextDouble();
            }

            Arrays.sort(nxArr);
            Arrays.sort(nyArr);

            boolean success = true;
            double current = 0;
            for (double xi : nxArr) {
                if (2 * (xi - current) > w) {
                    success = false;
                    break;
                }
                current = xi + w / 2.0;
            }
            if (current < 75.0) success = false;

            if (success) {
                current = 0;
                for (double yi : nyArr) {
                    if (2 * (yi - current) > w) {
                        success = false;
                        break;
                    }
                    current = yi + w / 2.0;
                }
                if (current < 100.0) success = false;
            }

            sb.append(success ? "YES\n" : "NO\n");
        }
        System.out.print(sb);
    }
}
