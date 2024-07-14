import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Set<Anagram> set = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            Anagram o = new Anagram(br.readLine());
            set.add(o);
        }

        for (Anagram anagram : set) {
            sb.append(anagram.word).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static class Anagram {
        private final String word;
        private final int[] alphabets;

        public Anagram(String word) {
            this.word = word;
            alphabets = new int[26];
            for (int i = 0; i < word.length(); i++) {
                alphabets[word.charAt(i) - 'a']++;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Anagram anagram = (Anagram) o;
            for (int i = 0; i < 26; i++) {
                if (alphabets[i] != anagram.alphabets[i]) return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            return java.util.Arrays.hashCode(alphabets);
        }
    }
}
