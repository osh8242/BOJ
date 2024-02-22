import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    // 메인 실행 함수
    public static void main(String[] args) throws IOException {
        run();
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    // 입력, 출력 실행 함수
    static void run() {
        int T = 0;
        try {
            T = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.getStackTrace();
        }
        while (T-- > 0) runTestCase();
        System.out.println(sb);
    }

    // 각 테스트 케이스 진행
    static void runTestCase() {
        try {
            String originStr = br.readLine();
            int sum = getReverseSum(originStr);
            sb.append(isSymmetric(sum) ? "YES" : "NO").append("\n");
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    // 원래 수와 뒤집은 수의 합을 구하는 함수
    static int getReverseSum(String originStr) {
        char[] lineCharArr = originStr.toCharArray();
        char[] reverseCharArr = new char[lineCharArr.length];
        for (int i = 0; i < lineCharArr.length; i++) {
            reverseCharArr[i] = lineCharArr[lineCharArr.length - 1 - i];
        }
        int origin = Integer.parseInt(originStr);
        int reverse = Integer.parseInt(new String(reverseCharArr));
        return origin + reverse;
    }

    // 숫자가 대칭인지 여부를 구하는 함수
    static boolean isSymmetric(int sum) {
        String sumStr = String.valueOf(sum);
        for (int i = 0; i < sumStr.length() / 2; i++) {
            if (sumStr.charAt(i) != sumStr.charAt(sumStr.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}