public class FindMinimum {
    public static void main(String[] args){
        int[] arr = {18, 12, -7, 14, 28};
        System.out.println(min(arr));
    }
    //assume that the list is not empty.
    static int min(int[] arr){
        int ans = arr[0];
        for (int i = 1; i<= arr.length-1 ; i++){
            if (arr[i]<ans){
                ans = arr[i];
            }
        }
        return ans;
    }
}
