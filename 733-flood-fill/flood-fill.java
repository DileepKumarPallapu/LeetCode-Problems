class Solution {
    public int[][] floodFill(
            int[][] image, int sr, int sc, int color) {

        int original = image[sr][sc];

        if (original == color)
            return image;

        fill(image, sr, sc, original, color);
        return image;
    }

    private void fill(
            int[][] image, int r, int c,
            int original, int color) {

        if (r < 0 || r >= image.length ||
            c < 0 || c >= image[0].length ||
            image[r][c] != original)
            return;

        image[r][c] = color;

        fill(image, r + 1, c, original, color);
        fill(image, r - 1, c, original, color);
        fill(image, r, c + 1, original, color);
        fill(image, r, c - 1, original, color);
    }
}