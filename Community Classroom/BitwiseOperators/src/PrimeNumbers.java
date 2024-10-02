public class PrimeNumbers {
    public static void main(String[] args) {
        int n = 36;
        for (int i = 0; i <= n; i++) {
            System.out.println(i + " " + isPrime(i));
        }
    }

    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        int c = 2;
        while (c * c <= n){
            if (n % c  == 0){
                return false;
            }
            c++;
        }
        return true; // no number divide return true
    }
}

