public class Count_0 {
    public static void main(String[] args) {
        System.out.println(count(3022020));
    }
    static int count(int n){
        return helper(n, 0);
    }
    // special patterns, how to pass a value to above calls
    static int helper(int n, int count) {
        if(n == 0){
            return count;
        }
        int remainder = n % 10;
            if (remainder == 0) {
                return helper(n / 10, count + 1);
            }
        return helper(n/10, count);
    }
}
