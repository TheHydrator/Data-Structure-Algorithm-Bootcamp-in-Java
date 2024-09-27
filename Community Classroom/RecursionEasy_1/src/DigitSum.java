public class DigitSum {
    public static void main(String[] args){
        int ans = 1342;
        System.out.println(digitSum(ans));
    }
    static int digitSum(int n){
        if (n == 0){
            return 0;
        }
        int remainder = n % 10; // 1342 ÷ 10 = 134 with a remainder of 2

        return remainder + digitSum(n/10); // int result = 1342 / 10 with a divisor of result 134;

    }
}
