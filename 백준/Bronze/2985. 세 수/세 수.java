import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static char[] op = {'+', '/', '*', '-'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        String answer = null;
        for (int i = 0; i < 4; i++) {
            if (a == getResult(b, c, i)) {
                answer = a + "=" + b + op[i] + c;
            }
        }
        if (answer == null) {
            for (int i = 0; i < 4; i++) {
                if (c == getResult(a, b, i)) {
                    answer = a + "" + op[i] + b + "=" + c;
                }
            }
        }
        System.out.println(answer);
    }

    static int getResult(int a, int b, int index) {
        switch (index) {
            case 0:
                return a + b;
            case 1:
                return a / b;
            case 2:
                return a * b;
            case 3:
                return a - b;
        }
        return -1;
    }
}