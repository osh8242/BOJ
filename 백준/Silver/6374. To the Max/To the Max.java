import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[][] array = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        scanner.close();

        System.out.println(findMaxSubRectangle(array, N));
    }

    public static int findMaxSubRectangle(int[][] array, int N) {
        int maxSum = Integer.MIN_VALUE;

        for (int left = 0; left < N; left++) {
            int[] temp = new int[N];

            for (int right = left; right < N; right++) {
                for (int i = 0; i < N; i++) {
                    temp[i] += array[i][right];
                }

                int currentMax = kadane(temp);
                if (currentMax > maxSum) {
                    maxSum = currentMax;
                }
            }
        }

        return maxSum;
    }

    public static int kadane(int[] array) {
        int maxEndingHere = array[0];
        int maxSoFar = array[0];

        for (int i = 1; i < array.length; i++) {
            maxEndingHere = Math.max(array[i], maxEndingHere + array[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
