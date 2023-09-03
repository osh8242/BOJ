import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String first = st.nextToken();
        String second = st.nextToken();

        BigInteger a = new BigInteger(first, 2);
        BigInteger b = new BigInteger(second, 2);
        BigInteger sum = a.add(b);

        System.out.println(sum.toString(2));

    }

}
