import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        // 테스트 케이스의 수를 입력받음
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            // 사샤가 발음한 단어를 입력받음
            String pronouncedWord = reader.readLine();
            int wordLength = pronouncedWord.length();

            // 사전의 단어 수를 입력받음
            int w = Integer.parseInt(reader.readLine());

            String[] dictionary = new String[w];
            for (int j = 0; j < w; j++) {
                dictionary[j] = reader.readLine();
            }

            // 가장 적은 대체로 일치하는 단어를 찾음
            String mostLikelyWord = null;
            int minSubstitutions = Integer.MAX_VALUE;

            for (String word : dictionary) {
                int substitutions = countSubstitutions(pronouncedWord, word);
                if (substitutions < minSubstitutions) {
                    minSubstitutions = substitutions;
                    mostLikelyWord = word;
                }
            }

            // 결과를 StringBuilder에 추가
            output.append(mostLikelyWord).append("\n");
        }

        // 최종 결과 출력
        System.out.print(output.toString());
    }

    private static int countSubstitutions(String pronouncedWord, String dictionaryWord) {
        int count = 0;
        for (int i = 0; i < pronouncedWord.length(); i++) {
            if (pronouncedWord.charAt(i) != dictionaryWord.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
