public class NumberOfDigits {
    public static void main(String[] args) {
        int n = 10;
        int base = 8;

        int ans = (int) (Math.log(n)/ Math.log(base)) + 1;
        System.out.println(ans);
    }
}
