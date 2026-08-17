class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] sAlpha = new int[26];
        int[] tAlpha = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sAlpha[s.charAt(i) - 'a']++;
            tAlpha[t.charAt(i) - 'a']++;
        }

        return Arrays.equals(sAlpha, tAlpha);
    }
}
