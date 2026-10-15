class Solution {
    private static class Item {
        TreeNode node;
        int row, col;

        Item(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map
            = new TreeMap<>();

        Queue<Item> queue = new LinkedList<>();
        queue.offer(new Item(root, 0, 0));

        while (!queue.isEmpty()) {
            Item cur = queue.poll();

            map.computeIfAbsent(cur.col, x -> new TreeMap<>())
               .computeIfAbsent(cur.row, x -> new PriorityQueue<>())
               .offer(cur.node.val);

            if (cur.node.left != null)
                queue.offer(new Item(cur.node.left,
                                     cur.row + 1, cur.col - 1));

            if (cur.node.right != null)
                queue.offer(new Item(cur.node.right,
                                     cur.row + 1, cur.col + 1));
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> rows
                : map.values()) {
            List<Integer> column = new ArrayList<>();

            for (PriorityQueue<Integer> values : rows.values()) {
                while (!values.isEmpty())
                    column.add(values.poll());
            }

            result.add(column);
        }

        return result;
    }
}