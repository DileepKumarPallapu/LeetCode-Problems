class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        // Count frequency
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        // Find maximum frequency
        int maxFreq = 0;

        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        // Count tasks having maximum frequency
        int countMax = 0;

        for (int f : freq) {
            if (f == maxFreq) {
                countMax++;
            }
        }

        // Calculate minimum intervals
        int result = (maxFreq - 1) * (n + 1) + countMax;

        return Math.max(result, tasks.length);
    }
}