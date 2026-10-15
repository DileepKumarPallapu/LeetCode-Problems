class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int provinces = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;

            provinces++;

            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(i);
            visited[i] = true;

            while (!stack.isEmpty()) {
                int current = stack.pop();

                for (int j = 0; j < n; j++) {
                    if (isConnected[current][j] == 1
                            && !visited[j]) {
                        visited[j] = true;
                        stack.push(j);
                    }
                }
            }
        }

        return provinces;
    }
}