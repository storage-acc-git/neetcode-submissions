class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int[] result = new int[k];

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < k; i++) {
            int max = freqMap.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
            result[i] = max;
            freqMap.remove(max);
        }

        return result;
    }
}