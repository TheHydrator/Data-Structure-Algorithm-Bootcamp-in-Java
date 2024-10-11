public class Pattern5 {
    public static void main(String[] args) {
        pattern5(5);

    }
    static void pattern5(int n){
        for (int row = 1; row <= 2* n; row++) {
            int totalColinRow = row > n ? 2 * n - row : row;
            //number of spaces requires in that row.
            int noOfSpaces = n - totalColinRow;
            for (int s = 0; s <= noOfSpaces; s++) {
                System.out.print(" ");
            }
            // for every row, run the col.
            for (int col = 1; col <= totalColinRow ; col++) {
                System.out.print("* " );
            }
            // when one row is printed, print a new line.
            System.out.println();
        }

    }
}
