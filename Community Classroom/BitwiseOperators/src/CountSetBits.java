public class CountSetBits {
    public static void main(String[] args) {
        int n = 200;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(setBits(n));
    }
    static int setBits(int n){
        int count = 0;
        while(n>0){
            n = n - (n & -n);

            count++;
        }
        return count;
    }
}
