import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            char[] chars = br.readLine().toCharArray();
            chars[0] = (char) (chars[0] >= 'a' ? chars[0]- 32 : chars[0]);
            sb.append(chars).append("\n");
        }
        System.out.println(sb);
    }
}
