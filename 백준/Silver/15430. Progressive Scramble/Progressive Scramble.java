import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int MODULO = 27;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String[] s = readLine(br.readLine());
            char mode = s[0].charAt(0);
            char[] chars = s[1].toCharArray();
            switch (mode) {
                case 'e':
                    encrypt(chars, sb);
                    break;
                case 'd':
                    decrypt(chars, sb);
                    break;
            }
        }
        System.out.println(sb);
    }

    static String[] readLine(String input) throws IOException {
        return new String[]{input.substring(0, input.indexOf(" ")), input.substring(input.indexOf(" ") + 1)};
    }

    static void encrypt(char[] chars, StringBuilder sb) {
        int prev = 0;
        int[] convert = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            int u = v(chars[i]) + prev;
            convert[i] = u;
            prev = u;
        }
        for (int i : convert) {
            sb.append(u(i));
        }
        sb.append("\n");
    }

    static void decrypt(char[] chars, StringBuilder sb) {
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) v(chars[i]);
        }
        int[] convert = new int[chars.length];
        convert[0] = chars[0];
        int prev = convert[0];
        for (int i = 1; i < chars.length; i++) {
            int current = chars[i];
            if (current < prev) {
                int r = prev - current;
                int m = r / MODULO;
                int n = r % MODULO;
                if (n != 0) m++;
                current += m * MODULO;
            }
            convert[i] = current;
            prev = current;
        }
        for (int i = convert.length - 1; i >= 1; i--) {
            convert[i] -= convert[i - 1];
        }
        for (int i : convert) {
            sb.append(u(i));
        }
        sb.append("\n");
    }

    static int v(char ch) {
        if (ch == ' ') return 0;
        return ch - 'a' + 1;
    }

    static char u(int i) {
        i %= MODULO;
        if (i == 0) return ' ';
        return (char) (i + 'a' - 1);
    }
}