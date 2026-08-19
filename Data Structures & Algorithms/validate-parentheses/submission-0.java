class Solution {
    public boolean isValid(String s) {
        Deque<Character> open = new ArrayDeque<>();
        Map<Character, Character> brackets = Map.of(
            '(',')',
            '[',']',
            '{','}'
        );

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                open.push(c);
            } else {
                if (open.isEmpty()) {
                    return false;
                }
                char opened = open.pop();
                if (c != brackets.get(opened)) {
                    return false;
                }
            }
        }
        return open.isEmpty();
    }
}
