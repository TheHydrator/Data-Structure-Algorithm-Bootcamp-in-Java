import java.util.*;

public class KnightTour {
    private static final int[] moveX = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] moveY = {1, 2, 2, 1, -1, -2, -2, -1};

    private static boolean isValidMove(int x, int y, int[][] board) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 0;
    }

    private static int getNumValidMoves(int x, int y, int[][] board) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int nextX = x + moveX[i];
            int nextY = y + moveY[i];
            if (isValidMove(nextX, nextY, board)) {
                count++;
            }
        }
        return count;
    }

    private static boolean tour(int x, int y, int moveCount, int[][] board) {
        board[x][y] = moveCount;
        if (moveCount == board.length * board[0].length) {
            return true; // Tour completed
        }

        List<int[]> nextMoves = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int nextX = x + moveX[i];
            int nextY = y + moveY[i];
            if (isValidMove(nextX, nextY, board)) {
                int numValidMoves = getNumValidMoves(nextX, nextY, board);
                nextMoves.add(new int[]{nextX, nextY, numValidMoves});
            }
        }

        nextMoves.sort(Comparator.comparingInt(a -> a[2]));

        for (int[] nextMove : nextMoves) {
            int nextX = nextMove[0];
            int nextY = nextMove[1];
            if (tour(nextX, nextY, moveCount + 1, board)) {
                return true;
            }
        }

        board[x][y] = 0; // Backtrack
        return false;
    }

    public static void main(String[] args) {
        int n = 8; // Board size
        int[][] board = new int[n][n];

        if (tour(0, 0, 1, board)) {
            for (int[] row : board) {
                System.out.println(Arrays.toString(row));
            }
        } else {
            System.out.println("No solution found.");
        }
    }
}
