import java.util.Arrays;
public class PatternsRecursion {
    public static void main(String[] args) {
//        int[] arr = { 4, 3, 2, 1};
//        selectionSort(arr, arr.length , 0, 0);
//        System.out.println(Arrays.toString(arr));
        triangle2(3, 0);
    }

    // make a triangle by using below method

    static void triangle2(int r, int c){
        //base condition.
        if(r == 0){
            return;
        }
        if(c<r){
            triangle2(r, c+1);
            System.out.print("* ");
        }else{
            triangle2(r-1, 0);
            System.out.println();
        }
    }
    static void triangle(int r, int c){
        //base condition.
         if(r == 0){
             return;
         }
         if(c<r){
             System.out.print("* ");
             triangle(r, c+1);
         }else{
             System.out.println();
             triangle(r-1, 0);
         }
    }
    static void bubble(int[] arr, int row, int col){
        if(row == 0){
            return;
        }
        if(col<row) {
            if (arr[col] > arr[col + 1]) {
                int temp = arr[col];
                arr[col] = arr[col + 1];
                arr[col + 1] = temp;
            }
            bubble(arr, row, col + 1);
        }else{
            bubble(arr, row - 1, 0);
        }
    }
    // selection sort using recursion
    static void selectionSort(int[] arr, int row, int col, int max){
        if(row == 0){
            return;
        }
        if(col<row) {
            if (arr[col] > arr[max]) {
                selectionSort(arr, row, col + 1, col);
            }else {
                selectionSort(arr, row, col + 1, max);
            }
        }else{
            int temp = arr[max];
            arr[max] = arr[row - 1];
            arr[row - 1] = temp;
            selectionSort(arr, row - 1, 0, 0);
        }
    }

}
