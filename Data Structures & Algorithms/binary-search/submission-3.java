class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0, end = n - 1;
        int mid = n / 2;

        while (start <= end) {
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                start = mid + 1;
            }
            if (target < nums[mid]) {
                end = mid - 1;
            }
            mid = (end + start) / 2;
        }
        return -1;
    }
}
