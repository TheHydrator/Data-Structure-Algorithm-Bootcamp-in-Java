public class Pattern4 {
    public static void main(String[] args) {
    pattern4(5);

}
    static void pattern4(int n){
        for (int row = 1; row <= 2* n; row++) {
            int totalColinRow = row > n ? 2 * n - row : row;
            // for every row, run the col.
            for (int col = 1; col <= totalColinRow ; col++) {
                System.out.print("* " );
            }
            // when one row is printed, print a new line.
            System.out.println();
        }

    }
}
