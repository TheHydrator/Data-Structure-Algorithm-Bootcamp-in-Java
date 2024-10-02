import java.util.ArrayList;

public class LinearSearchRecursion {
    public static void main(String[] args) {
        int [] arr = {10, 12, 1, 12, 4, 9, 20, 14, 12};
        int target = 12;
        System.out.println(findIndex(arr, target, 0));
        System.out.println(find(arr, target, 0));
        System.out.println(findLastIndex(arr, target, arr.length - 1));
        findAllIndex(arr, target, 0);
        System.out.println(list);
        System.out.println(findAllIndex(arr, target, 0, new ArrayList<>()));
        System.out.println(findAllIndex2(arr, target, 0));
    }
    static boolean find(int[] arr, int target, int index){
        // base condition
        if (arr[index] == arr.length){
            return false;
        }
        return arr[index] == target || find(arr, target, index + 1);
    }
    static int findIndex(int[] arr, int target, int index){
        // base condition
        if (arr[index] == arr.length){
            return -1;
        }
        if (arr[index] == target){
            return index;
        }else {
            return findIndex(arr, target, index + 1);
        }
    }
    static int findLastIndex(int[] arr, int target, int index){
        // base condition
        if (arr[index] == -1){
            return -1;
        }
        if (arr[index] == target){
            return index;
        }else {
            return findLastIndex(arr, target, index - 1);
        }
    }
    // find all the targets that are repeats in an array list
    // create a new array list


    // not a correct way to go for recursion.
    static ArrayList<Integer> list = new ArrayList<>();
    static void findAllIndex(int[] arr, int target, int index){
        // base condition.
        if(index == arr.length){
            return;
        }
        if(target == arr[index]){
            list.add(index);
        }
        findAllIndex(arr, target, index + 1);
    }


    static ArrayList<Integer> findAllIndex(int[] arr, int target, int index, ArrayList<Integer> list) {
        // base condition
        if (index == arr.length) { // here index is used instead of arr[index] because we need to store value in the list and not to compare the arr[index]= i.e. value with the target.
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        return findAllIndex(arr, target, index + 1, list);
    }
    static ArrayList<Integer> findAllIndex2(int[] arr, int target, int index) {
        ArrayList<Integer> list = new ArrayList<>();
        // base condition
        if (index == arr.length) {
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        ArrayList<Integer> ansFromBelowCalls =  findAllIndex2(arr, target, index + 1);

        list.addAll(ansFromBelowCalls);

        return list;
    }


}
