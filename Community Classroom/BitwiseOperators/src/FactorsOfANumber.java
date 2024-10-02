import java.util.ArrayList;

public class FactorsOfANumber {
    public static void main(String[] args) {
        factors3(36);
    }
    static void factors1(int n){
        for (int i = 1; i <= n; i++) {
            if (n % i == 0){
                System.out.println(i + " ");
            }
        }
    }
    // O (sqrt(n))

    static void factors2(int n){
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0){
                if(n / i == i){
                    System.out.println(i + " ");
                }else{
                    System.out.print(i + " " + n/i+ " ");
                }
            }
        }
    }

    // both time and space will be factors of O(root(n))
    static void factors3(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0){
                if(n / i == i){ // for example 36 factors include 6 two times, we want 6 one time to be printed so after giving this condition it will print once.
                    System.out.print(i + " ");
                }else{
                    System.out.print(i + " ");
                    list.add(n/i);
                }
            }
        }
        for (int i = list.size() -1; i >=0 ; i--) { // list.size() - 1 is the last index
            System.out.print(list.get(i) + " ");
        }
    }
}

