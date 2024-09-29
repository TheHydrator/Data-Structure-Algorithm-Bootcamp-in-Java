package QueryRange;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int []arr = {1, 3, 5, 2, 7, 6, 3, 1, 4, 8};
        int n = arr.length;

        // build a block array.
        int sqrt = (int) Math.sqrt(n);
        int block_id = -1;
        int[] blocks = new int[sqrt + 1]; // here number of blocks are sqrt(n) + 1.

        for (int i = 0; i < n; i++) {
            // new block is starting.
            if(i % sqrt == 0){
                block_id++;
            }
            blocks[block_id] = blocks[block_id]+ arr[i];
        }
        System.out.println(query(blocks, arr, 0, 0, 3));
    }

    private static int query(int[] blocks, int[] arr, int l, int r, int sqrt) {
        int sum = 0;
        // left part
        while(l % sqrt !=0 && l < r && l != 0){
            sum += arr[l];
            l++;
        }
        //middle part
        while(l + sqrt <= r){
            sum += blocks[l/sqrt];
            l+= sqrt;
        }
        // right part
        while(l <= r){
            sum += arr[l];
            l++;
        }
        return sum;
    }
    public void update(int[] blocks, int[]arr, int i, int val, int sqrt){
        int block_id = i/sqrt;
        blocks[block_id] = blocks[block_id] + (val - arr[i]);
    }
}
