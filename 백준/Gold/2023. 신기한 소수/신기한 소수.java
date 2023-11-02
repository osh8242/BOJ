import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static int N;
    
    //Main Function
    public static void main(String[] args) throws IOException {
        //자릿수 입력받기
        N = Integer.parseInt(br.readLine());
        //첫번째 자리수 1~9에 대해서 DFS 실행
        for (int i = 1; i < 10; i++)
            findInterestingPrimeNumberByDFS(i, 1);
        //정답 출력
        System.out.println(sb);
    }
    
    //DFS를 이용하여 신기한 소수 찾기
    static void findInterestingPrimeNumberByDFS(int number, int depth) {
        //해당 값이 소수가 아니면 종료
        if (!isPrime(number)) return;
        
        //N자리에 해당하면 StringBuilder에 추가 후 종료
        if (depth == N) {
            sb.append(number).append("\n");
            return;
        }
        
        //다음 자리수로 재귀호출
        for (int i = 0; i < 10; i++) {
            findInterestingPrimeNumberByDFS(number * 10 + i, depth + 1);
        }
    }
    
    //소수 판별 함수
    static boolean isPrime(int number) {
        if (number == 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++)
            if (number % i == 0) return false;
        return true;
    }

}