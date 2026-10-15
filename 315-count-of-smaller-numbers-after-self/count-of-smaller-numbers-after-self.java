class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;

        int[] indexes = new int[n];
        int[] temp = new int[n];
        int[] count = new int[n];

        for (int i = 0; i < n; i++)
            indexes[i] = i;

        sort(nums, indexes, temp, count, 0, n - 1);

        List<Integer> result = new ArrayList<>();

        for (int value : count)
            result.add(value);

        return result;
    }

    private void sort(
            int[] nums, int[] indexes, int[] temp,
            int[] count, int left, int right) {

        if (left >= right)
            return;

        int mid = left + (right - left) / 2;

        sort(nums, indexes, temp, count, left, mid);
        sort(nums, indexes, temp, count, mid + 1, right);

        int i = left;
        int j = mid + 1;
        int p = left;
        int rightSmaller = 0;

        while (i <= mid && j <= right) {
            if (nums[indexes[j]] < nums[indexes[i]]) {
                temp[p++] = indexes[j++];
                rightSmaller++;
            } else {
                count[indexes[i]] += rightSmaller;
                temp[p++] = indexes[i++];
            }
        }

        while (i <= mid) {
            count[indexes[i]] += rightSmaller;
            temp[p++] = indexes[i++];
        }

        while (j <= right)
            temp[p++] = indexes[j++];

        for (int x = left; x <= right; x++)
            indexes[x] = temp[x];
    }
}