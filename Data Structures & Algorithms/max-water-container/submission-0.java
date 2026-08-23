class Solution {
    public int maxArea(int[] heights) {
        int volume = 0;
        int l = 0, r = heights.length - 1;
        while (l < r) {
            int h = Math.min(heights[l], heights[r]);
            int w = r - l;
            volume = Math.max(volume, w * h);
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return volume;
    }
}

