import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input;
        while (!(input = br.readLine()).equals("#")) {
            char[] chars = input.toCharArray();
            int count = 0;
            for (int i = 0; i < chars.length - 1; i++) {
                if (chars[i] == '1') count++;
            }
            if (chars[input.length() - 1] == 'e') {
                if (count % 2 == 0) chars[input.length() - 1] = '0';
                else chars[input.length() - 1] = '1';
            } else {
                if (count % 2 == 0) chars[input.length() - 1] = '1';
                else chars[input.length() - 1] = '0';
            }
            sb.append(chars).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

}

