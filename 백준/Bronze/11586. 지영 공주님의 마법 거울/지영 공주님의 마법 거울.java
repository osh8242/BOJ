import java.io.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        char[][] mirror = new char[N][N];
        for (int i = 0; i < N; i++) {
            mirror[i] = br.readLine().toCharArray();
        }

        int status = Integer.parseInt(br.readLine());
        char[][] newMirror = getNewMirror(mirror, status);
        bw.write(getString(newMirror));
        bw.flush();
    }

    static char[][] getNewMirror(char[][] mirror, int status) {
        if (status == 1) return mirror;
        char[][] newMirror = new char[N][mirror[0].length];
        switch (status) {
            case 2:
                for (int i = 0; i < N; i++) newMirror[i] = getReverseChars(mirror[i]);
                break;
            case 3:
                for (int i = 0; i < N; i++) newMirror[N - 1 - i] = mirror[i];
                break;
        }
        return newMirror;
    }


    static char[] getReverseChars(char[] chars) {
        char[] reverse = new char[N];
        for (int i = 0; i < N; i++) {
            reverse[N - 1 - i] = chars[i];
        }
        return reverse;
    }

    static String getString(char[][] mirror) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(mirror[i]).append("\n");
        }
        return sb.toString();
    }
}
