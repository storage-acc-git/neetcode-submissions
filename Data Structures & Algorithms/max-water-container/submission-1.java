class Solution {
    public int maxArea(int[] heights) {
        int volume = 0;
        int l = 0, r = heights.length - 1;
        while (l < r) {
            volume = Math.max(volume, (r - l) * Math.min(heights[l], heights[r]));
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return volume;
    }
}

