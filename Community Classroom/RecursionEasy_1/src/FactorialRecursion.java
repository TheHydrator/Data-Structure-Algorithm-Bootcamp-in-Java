public class FactorialRecursion {
    public static void main(String[] args) {
        int ans = 5;
        System.out.println(factorial(ans));

    }
    static int factorial(int n){
        if (n <= 1){
            return 1;
        }
            return n * factorial(n-1);
    }
}
