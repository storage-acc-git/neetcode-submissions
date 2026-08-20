class Solution {
    public int[] twoSum(int[] nums, int target) {
        int index1 = 0, index2 = nums.length - 1;
        while (index1 < index2) {
            int sum = nums[index1] + nums[index2];
            if (sum == target) {
                return new int[] {index1+1, index2+1};
            }
            if (sum > target) {
                index2--;
            } else {
                index1++;
            }
        }
        return new int[0];
    }
}
