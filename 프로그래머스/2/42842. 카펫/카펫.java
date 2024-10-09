class Solution {
    public int[] solution(int brown, int yellow) {
        
        int totalTiles = brown + yellow;
        for (int height = 3 ; height <= totalTiles / height ; height++) {
            if (totalTiles % height == 0) {
                int width = totalTiles / height;
                if (brown == 2 * width + 2 * height - 4) {
                    return new int[]{width, height};
                }
            }
        }
        
        return null;
    }
}