class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        // Transform string
        StringBuilder t = new StringBuilder();
        t.append('^');

        for (int i = 0; i < s.length(); i++) {
            t.append('#');
            t.append(s.charAt(i));
        }

        t.append("#$");

        char[] chars = t.toString().toCharArray();
        int[] p = new int[chars.length];

        int center = 0;
        int right = 0;

        int maxLength = 0;
        int maxCenter = 0;

        for (int i = 1; i < chars.length - 1; i++) {

            int mirror = 2 * center - i;

            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // Expand around center
            while (chars[i + 1 + p[i]] ==
                   chars[i - 1 - p[i]]) {
                p[i]++;
            }

            // Update center and right boundary
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            // Update longest palindrome
            if (p[i] > maxLength) {
                maxLength = p[i];
                maxCenter = i;
            }
        }

        // Convert transformed index back to original string
        int start = (maxCenter - maxLength) / 2;

        return s.substring(start, start + maxLength);
    }
}