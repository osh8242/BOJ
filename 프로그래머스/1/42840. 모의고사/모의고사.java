import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] answers) {       
        int[][] submit = new int[4][];
        submit[1] = new int[]{1,2,3,4,5};
        submit[2] = new int[]{2,1,2,3,2,4,2,5};
        submit[3] = new int[]{3,3,1,1,2,2,4,4,5,5};
        
        int[] count = new int[4];     
        for(int i = 0 ; i < answers.length ; i++){
            for(int j = 1 ; j <= 3 ; j++){
                if(answers[i] == submit[j][i%submit[j].length]) count[j]++;
            }
        }
        int max = Math.max(count[1],Math.max(count[2],count[3])); 
        return IntStream.range(0, count.length)
                .filter(i -> count[i] == max)
                .toArray();
    }
}