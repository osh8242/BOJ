import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    static BigInteger[] bi = new BigInteger[101];
    static BigInteger[][] powCache = new BigInteger[101][101]; // bi[x].pow(j)를 저장할 캐시

    static {
        for (int i = 0; i <= 100; i++) {
            bi[i] = BigInteger.valueOf(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int j = 2; j <= n; j++) {
            sum += getCard(m, j);
        }
        System.out.println(sum);
    }

    static int getCard(int m, int j) {
        int count = 0;
        for (int x = 0; x <= m; x++) {
            for (int y = x; y <= m; y++) {
                for (int z = y; z <= m; z++) {
                    if (satisfied(x, y, z, j)) count++;
                }
            }
        }
        return count;
    }

    static boolean satisfied(int x, int y, int z, int j) {
        if (powCache[x][j] == null) {
            powCache[x][j] = bi[x].pow(j);
        }
        if (powCache[y][j] == null) {
            powCache[y][j] = bi[y].pow(j);
        }
        if (powCache[z][j] == null) {
            powCache[z][j] = bi[z].pow(j);
        }
        return powCache[x][j].add(powCache[y][j]).equals(powCache[z][j]);
    }
}
