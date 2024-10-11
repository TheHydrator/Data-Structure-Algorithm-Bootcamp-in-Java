public class Pattern7 {
    public static void main(String[] args) {
        pattern7(5);
    }

    static void pattern7(int n) {
        // run the loop for the given times.
        for (int row = 1; row <= 2 * n; row++) {
            int c = row > n ? 2 * n - row : row;

            // print leading spaces
            for (int space = 0; space < n - c; space++) {
                System.out.print("  ");
            }

            // print decreasing numbers
            for (int col = c; col >= 1; col--) {
                System.out.print(col+ " ");
            }

            // print increasing numbers (excluding 1)
            for (int col = 2; col <= c; col++) {
                System.out.print(col+ " ");
            }

            // move to the next line after completing each row
            System.out.println();
        }
    }
}
