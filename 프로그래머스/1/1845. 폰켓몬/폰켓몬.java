import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Solution {
    public int solution(int[] nums) {
        int n = nums.length;
        Set<Integer> ts = new HashSet<>();
        for (int i = 0; i < nums.length; i++) ts.add(nums[i]);
        return Math.min(ts.size(), n / 2);
    }
}