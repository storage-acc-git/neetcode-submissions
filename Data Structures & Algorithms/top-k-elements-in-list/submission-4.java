class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. build freq map
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = Integer.MIN_VALUE;
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            int freq = freqMap.get(num);
            maxFreq = freq > maxFreq ? freq : maxFreq;
        }

        // 2. build freq array (bucket list)
        List<Integer>[] freqArr = new List[maxFreq + 1];
        for (int i = 0; i <= maxFreq; i++) {
            freqArr[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            freqArr[entry.getValue()].add(entry.getKey());
        }

        // 3. build result array
        List<List<Integer>> lists = new ArrayList<>();
        int indexToK = 0;
        for (int i = maxFreq; indexToK < k && i > 0; i--) {
            lists.add(freqArr[i]);
            indexToK += freqArr[i].size();
        }
        var result =
            lists.stream().flatMap(Collection::stream).mapToInt(Integer::intValue).toArray();
        return result;
    }
}
