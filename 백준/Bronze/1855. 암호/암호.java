import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int[] evenColIndex;
    static int[] oddColIndex;

    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        char[] code = br.readLine().toCharArray();

        // 짝수행과 홀수행의 열 인덱스 설정
        evenColIndex = new int[K];
        oddColIndex = new int[K];
        for (int i = 0; i < K; i++) {
            evenColIndex[i] = i;
            oddColIndex[K - 1 - i] = i;
        }

        // 암호화된 문자열을 이용하여 문자 테이블표를 만든다
        char[][] codeTable = getCodeTable(code, K);

        // 테이블표를 이용하여 원본 문자열로 복호화
        String decodedString = getDecodedLine(codeTable, K);

        // 정답 출력
        System.out.println(decodedString);
    }

    // 암호화된 문자열을 이용하여 문자 테이블표를 만든다
    static char[][] getCodeTable(char[] code, int K){
        char[][] map = new char[code.length / K][K];
        for (int i = 0; i < code.length; i++) {
            char ch = code[i];
            int rowIndex = i / K; // 행 인덱스
            boolean isEvenRow = rowIndex % 2 == 0;
            int residue = i % K;
            int colIndex = isEvenRow ? evenColIndex[residue] : oddColIndex[residue]; // 열 인덱스
            map[rowIndex][colIndex] = ch;
        }
        return map;
    }

    // 테이블표를 이용하여 원본 문자열로 복호화
    static String getDecodedLine(char[][] codeTable, int K) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < K; j++) {
            for (char[] chars : codeTable) {
                sb.append(chars[j]);
            }
        }
        return sb.toString();
    }
}