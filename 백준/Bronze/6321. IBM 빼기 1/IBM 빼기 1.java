import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            sb.append("String #").append(i).append("\n");
            char[] chars = br.readLine().toCharArray();
            for (char c : chars) {
                sb.append(c != 'Z' ? (char) (c + 1) : 'A');
            }
            sb.append("\n\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}