class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(0);
        visited[0] = true;
        int count = 0;

        while (!stack.isEmpty()) {
            int room = stack.pop();
            count++;

            for (int key : rooms.get(room)) {
                if (!visited[key]) {
                    visited[key] = true;
                    stack.push(key);
                }
            }
        }

        return count == rooms.size();
    }
}