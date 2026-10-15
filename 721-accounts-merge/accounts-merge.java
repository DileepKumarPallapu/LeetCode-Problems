class Solution {
    public List<List<String>> accountsMerge(
            List<List<String>> accounts) {

        Map<String, String> owner = new HashMap<>();
        Map<String, Set<String>> graph = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                owner.put(email, name);
                graph.computeIfAbsent(email, x -> new HashSet<>());

                if (i > 1) {
                    String previous = account.get(i - 1);
                    graph.get(email).add(previous);
                    graph.get(previous).add(email);
                }
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();

        for (String email : graph.keySet()) {
            if (!visited.add(email))
                continue;

            List<String> merged = new ArrayList<>();
            Deque<String> stack = new ArrayDeque<>();
            stack.push(email);

            while (!stack.isEmpty()) {
                String current = stack.pop();
                merged.add(current);

                for (String next : graph.get(current)) {
                    if (visited.add(next))
                        stack.push(next);
                }
            }

            Collections.sort(merged);
            merged.add(0, owner.get(email));
            result.add(merged);
        }

        return result;
    }
}