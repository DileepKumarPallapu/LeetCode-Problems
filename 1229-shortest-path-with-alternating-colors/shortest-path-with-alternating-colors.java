class Solution {
    public int[] shortestAlternatingPaths(
            int n, int[][] redEdges, int[][] blueEdges) {

        List<Integer>[][] graph = new ArrayList[2][n];

        for (int color = 0; color < 2; color++) {
            for (int i = 0; i < n; i++)
                graph[color][i] = new ArrayList<>();
        }

        for (int[] e : redEdges)
            graph[0][e[0]].add(e[1]);

        for (int[] e : blueEdges)
            graph[1][e[0]].add(e[1]);

        int[][] dist = new int[2][n];

        for (int[] row : dist)
            Arrays.fill(row, -1);

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});

        dist[0][0] = 0;
        dist[1][0] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0];
            int lastColor = cur[1];
            int nextColor = 1 - lastColor;

            for (int next : graph[nextColor][node]) {
                if (dist[nextColor][next] == -1) {
                    dist[nextColor][next] =
                        dist[lastColor][node] + 1;

                    queue.offer(new int[]{next, nextColor});
                }
            }
        }

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int red = dist[0][i];
            int blue = dist[1][i];

            if (red == -1)
                answer[i] = blue;
            else if (blue == -1)
                answer[i] = red;
            else
                answer[i] = Math.min(red, blue);
        }

        return answer;
    }
}