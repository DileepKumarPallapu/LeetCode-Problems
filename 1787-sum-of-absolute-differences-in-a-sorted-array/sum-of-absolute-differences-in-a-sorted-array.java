class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];

            int left = x * i - leftSum;

            int rightSum = totalSum - leftSum - x;

            int rightCount = n - i - 1;
            int right = rightSum - x * rightCount;

            result[i] = left + right;

            leftSum += x;
        }

        return result;
    }
}