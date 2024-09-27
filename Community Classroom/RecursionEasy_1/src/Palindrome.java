public class Palindrome {
    static long reverse(int n){
        // sometimes you may need some additional value in the arguments.
        // in that case, make some another function
        int digits = (int) (Math.log10(n) +1);//Math.log10(12345) is approximately 4.091315159. Casting to an integer, (int) (Math.log10(12345)) gives 4. Adding 1, you get int digits = 5;
        return helper(n, digits);
    }

    static long helper(int n, int digits) {
        if (n%10 == n){
            return n;
        }
        int remainder = n % 10;
        return remainder * (long)(Math.pow(10, digits -1)) + helper(n/10, digits -1);

    }
    static boolean isPalindrome(int n){
        return (n == reverse(n));
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(123454321));
//        System.out.println(sum);
    }


}
