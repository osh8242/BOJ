import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

class Solution {
    static boolean[] isPrime;
    static Set<Integer> primesSet = new HashSet<>();

    public int solution(String numbers) {
        int maxNumber = (int) Math.pow(10, numbers.length());
        isPrime = new boolean[maxNumber];
        
        sieveOfEratosthenes(maxNumber);
        
        boolean[] visited = new boolean[numbers.length()];
        findAllCombinations(numbers, "", visited);
        
        return primesSet.size();
    }

    void sieveOfEratosthenes(int maxNumber) {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        for (int i = 2; i * i < maxNumber; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < maxNumber; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    void findAllCombinations(String numbers, String current, boolean[] visited) {
        if (!current.isEmpty()) {
            int num = Integer.parseInt(current);
            if (isPrime[num]) {
                primesSet.add(num);
            }
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                findAllCombinations(numbers, current + numbers.charAt(i), visited);
                visited[i] = false;
            }
        }
    }

}
