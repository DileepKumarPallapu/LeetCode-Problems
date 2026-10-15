class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> Long.compare(distance(b), distance(a))
        );

        for (int[] point : points) {
            heap.offer(point);

            if (heap.size() > k)
                heap.poll();
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++)
            result[i] = heap.poll();

        return result;
    }

    private long distance(int[] p) {
        return (long) p[0] * p[0]
             + (long) p[1] * p[1];
    }
}