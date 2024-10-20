import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int[] alphabet = new int[26];
            char[] chars = br.readLine().toCharArray();
            boolean isSatisfied = true;
            for (int i = 0; i < chars.length; i++) {
                int idx = chars[i] - 'A';
                alphabet[idx]++;
                if (alphabet[idx] % 3 == 0 && (i == chars.length - 1 || chars[i++] != chars[i])) {
                    isSatisfied = false;
                    break;
                }
            }
            sb.append(isSatisfied ? "OK" : "FAKE").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }


}