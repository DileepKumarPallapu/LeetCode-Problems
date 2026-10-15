class Solution {
    public int rob(int[] nums) {
        int twoBack = 0;
        int oneBack = 0;

        for (int value : nums) {
            int current = Math.max(
                oneBack, twoBack + value
            );

            twoBack = oneBack;
            oneBack = current;
        }

        return oneBack;
    }
}