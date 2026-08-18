class Solution {
    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return "";
        }
        String lengths =
            strs.stream().map(s -> String.valueOf(s.length())).collect(Collectors.joining(","));
        String words = strs.stream().collect(Collectors.joining());
        return lengths + "#" + words;
    }

    public List<String> decode(String str) {
        List<String> decodedStringList = new ArrayList<>();
        if (str.isEmpty()) {
            return decodedStringList;
        }

        int splitIndex = str.indexOf('#');
        String[] lengthStrings = str.substring(0, splitIndex).split(",");
        int[] lengths = Arrays.stream(lengthStrings).mapToInt(Integer::parseInt).toArray();
        String words = str.substring(splitIndex + 1, str.length());

        int i = 0;
        for (int len : lengths) {
            String word = words.substring(i, len + i);
            decodedStringList.add(word);
            i += len;
        }

        return decodedStringList;
    }
}
