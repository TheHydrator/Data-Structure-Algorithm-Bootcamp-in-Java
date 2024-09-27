import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class subSet {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        List<List<Integer>> ans = SubSetDuplicate(arr);
        for(List<Integer> list : ans){//The final result is a list of lists (List<List<Integer>>) containing all subsets of the input array. The code uses iteration and avoids recursion to achieve this.
            System.out.println(list);
        }

    }
    static List<List<Integer>> SubSet(int[] arr){
        List<List<Integer>> outer  = new ArrayList<>();// Initializes an outer list to store all subsets.
        outer.add(new ArrayList<>());//Adds an empty list to the outer list, representing the empty subset.
        for(int num : arr){
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));//Creates a copy of the current subset in the outer list.
                internal.add(num);//Adds the current element of the array to the copied subset.
                outer.add(internal);//Adds the modified subset back to the outer list.
            }
        }

        return outer;
    }

    static List<List<Integer>> SubSetDuplicate(int[] arr){
        Arrays.sort(arr);
        // Initializes an outer list to store all subsets.
        List<List<Integer>> outer  = new ArrayList<>();
        outer.add(new ArrayList<>());//Adds an empty list to the outer list, representing the empty subset.
        int start = 0;
        int end = 0;

        for(int i = 0; i< arr.length ; i++){
            start = 0;
            // if current and previous element is same, start = end + 1
            if(i > 0 && arr[i] == arr[i - 1]){
                start = end + 1;
            }
            end = outer.size() - 1;
            int n = outer.size();
            for (int j = start;  j< n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));//Creates a copy of the current subset in the outer list.
                internal.add(arr[i]);//Adds the current element of the array to the copied subset.
                outer.add(internal);//Adds the modified subset back to the outer list.
            }
        }

        return outer;
    }
}
