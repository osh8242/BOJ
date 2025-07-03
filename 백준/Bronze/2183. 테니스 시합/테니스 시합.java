import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        String[] sp = br.readLine().split(" ");
        int N = Integer.parseInt(sp[0]);
        String S = sp[1];

        int[] setWins  = new int[N];     // 세트 승리 횟수
        int[] gameWins = new int[N];     // 현재 세트에서의 게임 승리 횟수
        int[] pts      = new int[N];     // 현재 게임에서의 포인트

        for (char ch : S.toCharArray()) {
            int x = ch - 'A';

            // (1) x의 현재 포인트가 3이고, 다른 모든 선수의 포인트 ≤ 2
            boolean cond1 = (pts[x] == 3);
            if (cond1) {
                for (int i = 0; i < N; i++) {
                    if (i != x && pts[i] > 2) {
                        cond1 = false;
                        break;
                    }
                }
            }

            // (2) x의 포인트가 4
            boolean cond2 = (pts[x] == 4);

            // (3) 다른 선수가 포인트 4
            int yWith4 = -1;
            for (int i = 0; i < N; i++) {
                if (i != x && pts[i] == 4) {
                    yWith4 = i;
                    break;
                }
            }

            // (1) or (2) 이면 x가 게임 승리
            if (cond1 || cond2) {
                // 게임 승리 처리
                gameWins[x]++;
                // 포인트 초기화
                for (int i = 0; i < N; i++) {
                    pts[i] = 0;
                }

                // 세트 승리 판단
                if (gameWins[x] >= 6) {
                    boolean twoGameLead = true;
                    for (int i = 0; i < N; i++) {
                        if (i != x && gameWins[x] - gameWins[i] < 2) {
                            twoGameLead = false;
                            break;
                        }
                    }
                    if (twoGameLead) {
                        // 이 세트에서 x가 모든 게임을 휩쓸었는지
                        int totalGames = 0;
                        for (int i = 0; i < N; i++) {
                            totalGames += gameWins[i];
                        }
                        int setsGained = (gameWins[x] == totalGames) ? 2 : 1;

                        setWins[x] += setsGained;

                        // 매치 승리 검사
                        if (setWins[x] >= 3) {
                            System.out.println((char)('A' + x));
                            return;
                        }

                        // 새 세트 준비
                        for (int i = 0; i < N; i++) {
                            gameWins[i] = 0;
                        }
                    }
                }

            } else if (yWith4 != -1) {
                // (3) 다른 선수 yWith4의 포인트 1점 차감
                pts[yWith4]--;
            } else {
                // (4) x가 포인트 1점 획득
                pts[x]++;
            }
        }
    }
}
