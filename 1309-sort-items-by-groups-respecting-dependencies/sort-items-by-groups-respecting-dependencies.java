class Solution {
    public int[] sortItems(
            int n, int m, int[] group,
            List<List<Integer>> beforeItems) {

        int nextGroup = m;

        for (int i = 0; i < n; i++) {
            if (group[i] == -1)
                group[i] = nextGroup++;
        }

        int totalGroups = nextGroup;

        List<Set<Integer>> itemGraph = new ArrayList<>();
        List<Set<Integer>> groupGraph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            itemGraph.add(new HashSet<>());

        for (int i = 0; i < totalGroups; i++)
            groupGraph.add(new HashSet<>());

        int[] itemIn = new int[n];
        int[] groupIn = new int[totalGroups];

        for (int i = 0; i < n; i++) {
            for (int pre : beforeItems.get(i)) {
                if (itemGraph.get(pre).add(i))
                    itemIn[i]++;

                if (group[pre] != group[i] &&
                    groupGraph.get(group[pre]).add(group[i])) {
                    groupIn[group[i]]++;
                }
            }
        }

        List<Integer> groupOrder = topo(groupGraph, groupIn);
        List<Integer> itemOrder = topo(itemGraph, itemIn);

        if (groupOrder.size() != totalGroups ||
            itemOrder.size() != n)
            return new int[0];

        List<List<Integer>> grouped = new ArrayList<>();

        for (int i = 0; i < totalGroups; i++)
            grouped.add(new ArrayList<>());

        for (int item : itemOrder)
            grouped.get(group[item]).add(item);

        int[] result = new int[n];
        int index = 0;

        for (int g : groupOrder) {
            for (int item : grouped.get(g))
                result[index++] = item;
        }

        return index == n ? result : new int[0];
    }

    private List<Integer> topo(
            List<Set<Integer>> graph, int[] indegree) {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }

        List<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {
            int current = queue.poll();
            order.add(current);

            for (int next : graph.get(current)) {
                indegree[next]--;

                if (indegree[next] == 0)
                    queue.offer(next);
            }
        }

        return order;
    }
}