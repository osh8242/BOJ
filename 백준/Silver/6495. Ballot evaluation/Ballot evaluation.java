import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<String, Double> voteMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());

        while (p-- > 0) {
            st = new StringTokenizer(br.readLine());
            String party = st.nextToken();
            Double share = Double.parseDouble(st.nextToken());
            voteMap.put(party, share);
        }

        int index = 1;
        while (g-- > 0) {
            st = new StringTokenizer(br.readLine());
            Double leftSum = 0d;
            String ref = "";
            int refNum = 0;

            while (st.hasMoreTokens()) {
                String elem = st.nextToken();
                if (voteMap.containsKey(elem)) {
                    leftSum += voteMap.get(elem);
                } else if (!elem.equals("+")) {
                    if (ref.isEmpty()) ref = elem;
                    else refNum = Integer.parseInt(elem);
                }
            }

            boolean isCorrect = switch (ref) {
                case "<" -> roundToTwoDecimalPlaces(leftSum) < refNum;
                case ">" -> roundToTwoDecimalPlaces(leftSum) > refNum;
                case "<=" -> roundToTwoDecimalPlaces(leftSum) <= refNum;
                case ">=" -> roundToTwoDecimalPlaces(leftSum) >= refNum;
                case "=" -> roundToTwoDecimalPlaces(leftSum) == refNum;
                default -> false;
            };

            sb.append("Guess #")
                    .append(index++)
                    .append(" was ")
                    .append(isCorrect ? "correct" : "incorrect")
                    .append(".\n");
        }
        bw.write(sb.toString());
        bw.flush();

    }

    static double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

}
