public class Pattern6 {
    public static void main(String[] args) {
        pattern6(5);
    }

    static void pattern6(int n) {
        // run the loop for the given times.
        for (int row = 1; row <= n; row++) {

            // print leading spaces
            for (int space = 0; space < n - row; space++) {
                System.out.print(" ");
            }

            // print decreasing numbers
            for (int col = row; col >= 1; col--) {
                System.out.print(col);
            }

            // print increasing numbers (excluding 1)
            for (int col = 2; col <= row; col++) {
                System.out.print(col);
            }

            // move to the next line after completing each row
            System.out.println();
        }
    }
}
