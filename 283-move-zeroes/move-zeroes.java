class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;

        for (int x : nums)
            if (x != 0)
                nums[j++] = x;

        while (j < nums.length)
            nums[j++] = 0;
    }
}