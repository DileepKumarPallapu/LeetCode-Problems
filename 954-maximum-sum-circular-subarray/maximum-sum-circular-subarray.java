class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int totalSum = 0;

        int currentMax = 0;
        int maxSum = nums[0];

        int currentMin = 0;
        int minSum = nums[0];

        for (int num : nums) {

            // Kadane's algorithm for maximum subarray
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            // Kadane's algorithm for minimum subarray
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);

            totalSum += num;
        }

        // If all elements are negative
        if (maxSum < 0) {
            return maxSum;
        }

        // Maximum circular subarray
        int circularSum = totalSum - minSum;

        return Math.max(maxSum, circularSum);
    }
}