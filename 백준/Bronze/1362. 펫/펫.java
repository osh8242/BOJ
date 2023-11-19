import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        scenario:
        for (int i = 1; ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int O = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            if (O == 0 && W == 0) break;

            st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());
            boolean isAlive = true;

            while (command != '#') {
                if (isAlive) {
                    switch (command) {
                        case 'E':
                            W = exercise(W, num);
                            break;
                        case 'F':
                            W = feed(W, num);
                            break;
                    }
                    if (W <= 0) {
                        isAlive = false;
                    }
                }
                st = new StringTokenizer(br.readLine());
                command = st.nextToken().charAt(0);
                num = Integer.parseInt(st.nextToken());
            }
            if (!isAlive)
                sb.append(i).append(" RIP").append("\n");
            else
                sb.append(i).append(" :-").append(isHealthy(O, W) ? ")" : "(").append("\n");
        }
        System.out.println(sb);

    }

    static int exercise(int weight, int num) {
        return weight - num;
    }

    static int feed(int weight, int num) {
        return weight + num;
    }

    static boolean isHealthy(int O, int W) {
        return W < O * 2 && W * 2 > O;
    }

}
