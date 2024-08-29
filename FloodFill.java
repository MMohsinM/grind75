import java.util.Deque;
import java.util.LinkedList;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        final int m = image.length;
        final int n = image[0].length;
        int[][] floodFill = new int[m][n];
        Deque<Integer[]> stack = new LinkedList<>();
        int x = sr, y = sc;
        int originalColor = image[sr][sc];
        stack.addFirst(new Integer[] { sr, sc });
        do {
            Integer[] address = stack.removeFirst();
            x = address[0];
            y = address[1];
            floodFill[x][y] = 1;
            image[x][y] = color;
            if (x + 1 < m) {
                if (floodFill[x + 1][y] == 0 && image[x + 1][y] == originalColor)
                    stack.addFirst(new Integer[] { x + 1, y });
            }
            if (x - 1 >= 0) {
                if (floodFill[x - 1][y] == 0 && image[x - 1][y] == originalColor)
                    stack.addFirst(new Integer[] { x - 1, y });
            }
            if (y - 1 >= 0) {
                if (floodFill[x][y - 1] == 0 && image[x][y - 1] == originalColor)
                    stack.addFirst(new Integer[] { x, y - 1 });
            }
            if (y + 1 < n) {
                if (floodFill[x][y + 1] == 0 && image[x][y + 1] == originalColor)
                    stack.addFirst(new Integer[] { x, y + 1 });
            }

        } while (stack.size() != 0);
        return image;
    }
}
