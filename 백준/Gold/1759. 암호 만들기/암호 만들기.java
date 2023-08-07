import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int L, C;
    static StringBuilder sb = new StringBuilder();
    static char[] chars;
    static char[] code;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        chars = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }
        code = new char[L];
        Arrays.sort(chars);
        for (int i = 0; i <= C - L; i++) {
            dfs(i, 0, 0, 0);
        }
        System.out.println(sb);
    }

    static void dfs(int charsIndex, int codeIndex, int vowels, int consonants) {
        code[codeIndex] = chars[charsIndex];
        if (isVowel(chars[charsIndex])) {
            vowels++;
        } else {
            consonants++;
        }
        if (codeIndex == L - 1) {
            if (vowels >= 1 && consonants >= 2) {
                sb.append(new String(code) + "\n");
            }
            return;
        }
        for (int i = charsIndex + 1; i <= C - (L - codeIndex - 1); i++) {
            dfs(i, codeIndex + 1, vowels, consonants);
        }
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
