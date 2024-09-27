public class DigitProduct {
    public static void main(String[] args) {
        int ans = 1142;
        System.out.println(digitProduct(ans));
    }
    static int digitProduct(int n){
        if (n%10 == n){ // n%10 is given here so that for 0 case it gives a correct answer.
            return n;
        }
        int remainder = n % 10; // 1342 ÷ 10 = 134 with a remainder of 2

        return remainder * digitProduct(n/10); // int result = 1342 / 10 with a divisor of result 134;


    }
}
