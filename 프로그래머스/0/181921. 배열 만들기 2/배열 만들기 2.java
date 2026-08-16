import java.util.*;

class Solution {
    private final List<Integer> nums = new ArrayList<>();
    private int l, r;

    public int[] solution(int l, int r) {
        this.l = l;
        this.r = r;
        generate(5);
        Collections.sort(nums);
        return nums.isEmpty()
                ? new int[]{-1}
                : nums.stream().mapToInt(Integer::intValue).toArray();
    }

    private void generate(int current) {
        if (current > r) return;
        if (current >= l) nums.add(current);
        generate(current * 10);
        generate(current * 10 + 5);
    }
}