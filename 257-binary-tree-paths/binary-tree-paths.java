class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        build(root, "", result);
        return result;
    }

    private void build(
            TreeNode node, String path,
            List<String> result) {

        if (node == null)
            return;

        String current = path.isEmpty()
            ? "" + node.val
            : path + "->" + node.val;

        if (node.left == null && node.right == null) {
            result.add(current);
            return;
        }

        build(node.left, current, result);
        build(node.right, current, result);
    }
}