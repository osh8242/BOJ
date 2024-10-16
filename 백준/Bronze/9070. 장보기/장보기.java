import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int price = Integer.MAX_VALUE;
            double value = Double.MIN_VALUE;
            while(N-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                double W = Double.parseDouble(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                double currentValue = W / C;
                if (value < currentValue) {
                    price = C;
                    value = currentValue;
                } else if (value == currentValue && price > C) {
                    price = C;
                    value = currentValue;
                }
            }
            sb.append(price).append("\n");
        }
        System.out.println(sb);
    }

}

