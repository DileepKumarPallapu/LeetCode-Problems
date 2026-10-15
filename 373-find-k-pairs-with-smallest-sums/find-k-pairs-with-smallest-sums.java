class Solution {
    public List<List<Integer>> kSmallestPairs(
            int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0)
            return result;

        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        for (int i = 0; i < Math.min(nums1.length, k); i++)
            heap.offer(new int[]{nums1[i] + nums2[0], i, 0});

        while (k-- > 0 && !heap.isEmpty()) {
            int[] cur = heap.poll();

            result.add(Arrays.asList(
                nums1[cur[1]], nums2[cur[2]]
            ));

            int j = cur[2] + 1;

            if (j < nums2.length) {
                heap.offer(new int[]{
                    nums1[cur[1]] + nums2[j], cur[1], j
                });
            }
        }

        return result;
    }
}