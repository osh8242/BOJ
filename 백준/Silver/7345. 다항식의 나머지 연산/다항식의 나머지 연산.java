import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder out = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            String line;
            do { line = br.readLine(); } while (line != null && line.trim().isEmpty());
            String[] t1 = line.trim().split("\\s+");
            BigInteger f = BigInteger.ZERO;
            for (int i = 1; i < t1.length; i++) {
                f = f.shiftLeft(1);
                if (t1[i].equals("1")) f = f.or(BigInteger.ONE);
            }
            do { line = br.readLine(); } while (line != null && line.trim().isEmpty());
            String[] t2 = line.trim().split("\\s+");
            BigInteger g = BigInteger.ZERO;
            for (int i = 1; i < t2.length; i++) {
                g = g.shiftLeft(1);
                if (t2[i].equals("1")) g = g.or(BigInteger.ONE);
            }
            do { line = br.readLine(); } while (line != null && line.trim().isEmpty());
            String[] t3 = line.trim().split("\\s+");
            BigInteger h = BigInteger.ZERO;
            for (int i = 1; i < t3.length; i++) {
                h = h.shiftLeft(1);
                if (t3[i].equals("1")) h = h.or(BigInteger.ONE);
            }
            BigInteger prod = BigInteger.ZERO;
            BigInteger cur = f;
            int gb = g.bitLength();
            for (int i = 0; i < gb; i++) {
                if (g.testBit(i)) prod = prod.xor(cur);
                cur = cur.shiftLeft(1);
            }
            int degH = h.bitLength() - 1;
            if (!h.equals(BigInteger.ZERO)) {
                while (prod.bitLength() - 1 >= degH) {
                    int shift = prod.bitLength() - 1 - degH;
                    prod = prod.xor(h.shiftLeft(shift));
                }
            }
            int outLen = prod.bitLength();
            if (outLen == 0) {
                out.append("1 0\n");
            } else {
                out.append(outLen);
                for (int p = outLen - 1; p >= 0; p--) out.append(' ').append(prod.testBit(p) ? '1' : '0');
                out.append('\n');
            }
        }
        System.out.print(out.toString());
    }
}
