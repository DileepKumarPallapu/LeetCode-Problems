class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[][] dist = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 0)
                    queue.offer(new int[]{r, c});
                else
                    dist[r][c] = Integer.MAX_VALUE;
            }
        }

        int[][] dirs = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] d : dirs) {
                int r = cur[0] + d[0];
                int c = cur[1] + d[1];

                if (r >= 0 && r < rows &&
                    c >= 0 && c < cols &&
                    dist[r][c] > dist[cur[0]][cur[1]] + 1) {

                    dist[r][c] = dist[cur[0]][cur[1]] + 1;
                    queue.offer(new int[]{r, c});
                }
            }
        }

        return dist;
    }
}