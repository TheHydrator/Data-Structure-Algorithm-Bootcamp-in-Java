public class Pattern2 {
    public static void main(String[] args) {
        pattern2(4);

    }
    static void pattern2(int n){
        for (int row = 1; row <= n; row++) {
            // for every row, run the col.
            for (int col = 1; col <=n ; col++) {
                System.out.print("* ");
            }
            // when one row is printed, print a new line.
            System.out.println();
        }

    }
}
