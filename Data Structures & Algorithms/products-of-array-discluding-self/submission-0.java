class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        prefix[0] = 1;
        suffix[nums.length-1] = 1;

        for (int left = 1, right = nums.length-2; left < nums.length; left++, right--) {
            prefix[left] = prefix[left - 1] * nums[left - 1];
            suffix[right] = suffix[right + 1] * nums[right + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            output[i] = prefix[i] * suffix[i];
        }

        return output;
    }
}