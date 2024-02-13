import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        int mode = determineMode(input);
        int answer = getDecimalValue(input, mode);
        sb.append(answer);
        System.out.println(sb);
    }

    static int determineMode(String input) {
        if (input.charAt(0) != '0') return 10;
        if (input.charAt(1) != 'x') return 8;
        if (input.charAt(1) == 'x') return 16;
        return -1;
    }

    static int getDecimalValue(String input, int mode) {
        if (mode == 10) return Integer.parseInt(input);
        if (mode == 8) input = input.substring(input.indexOf('0') + 1);
        if (mode == 16) input = input.substring(input.indexOf('x') + 1);
        return calculateDecimalValue(input, mode);
    }

    static int calculateDecimalValue(String input, int mode) {
        int answer = 0;
        int factor = 1;
        for (int i = input.length() - 1; i >= 0; i--) {
            char ch = input.charAt(i);
            int value = ch < ':' ? ch - '0' : ch - 'W';
            answer += value * factor;
            factor *= mode;
        }
        return answer;
    }

}