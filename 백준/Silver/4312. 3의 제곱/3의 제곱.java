import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final List<BigInteger> powersOfThree = new ArrayList<>();

    static {
        BigInteger base = BigInteger.ONE;
        for (int i = 0; i < 70; i++) {
            powersOfThree.add(base);
            base = base.multiply(BigInteger.valueOf(3));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while ((input = br.readLine()) != null) {
            if ("0".equals(input.trim())) {
                break;
            }

            List<BigInteger> subset = getBigIntegers(input);

            StringBuilder sb = new StringBuilder();
            sb.append("{");
            if (!subset.isEmpty()) {
                sb.append(" ");
                for (int i = 0; i < subset.size(); i++) {
                    sb.append(subset.get(i));
                    if (i < subset.size() - 1) {
                        sb.append(", ");
                    }
                }
            }
            sb.append(" }");

            System.out.println(sb);
        }
    }

    private static List<BigInteger> getBigIntegers(String input) {
        BigInteger n = new BigInteger(input.trim());

        BigInteger indexVal = n.subtract(BigInteger.ONE);

        List<BigInteger> subset = new ArrayList<>();
        int index = 0;
        while (indexVal.compareTo(BigInteger.ZERO) > 0) {
            if (indexVal.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE)) {
                subset.add(powersOfThree.get(index));
            }
            indexVal = indexVal.divide(BigInteger.valueOf(2));
            index++;
        }
        return subset;
    }
}
