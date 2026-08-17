class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // frequency map
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> a[1] - b[1]); // comparing values (counts)
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minheap.offer(new int[] { entry.getKey(), entry.getValue() });
            if (minheap.size() > k) {
                minheap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minheap.poll()[0];
        }
        return result;
    }
}