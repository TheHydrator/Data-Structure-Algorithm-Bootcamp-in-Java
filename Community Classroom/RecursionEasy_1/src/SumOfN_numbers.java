public class SumOfN_numbers {
    public static void main(String[] args) {
        int ans = 5;
        System.out.println(sum(ans));
    }
    static int sum(int n){
        if (n == 0){
            return 0;
        }
        return n + sum(n-1);
    }
}
