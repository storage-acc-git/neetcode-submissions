class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String anagram = new String(chars);

            var list = map.getOrDefault(anagram, new ArrayList());
            list.add(str);
            map.put(anagram, list);
        }

        return new ArrayList(map.values());
    }
}

//