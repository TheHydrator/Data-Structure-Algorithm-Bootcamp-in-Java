public class ArrayPrime {
    public static void main(String[] args) {
        int n = 100;
        boolean[] primes = new boolean[n + 1]; // upto n+1 because we have to include 100 not upto 0 to 99
        sieve(n, primes);
    }
    // false in array means number is prime
    static void sieve(int n, boolean[] primes) {
        for (int i = 2; i * i <= n; i++) {
            if (!primes[i]) {
                for (int j = 2 * i; j <= n; j += i) {
                    primes[j] = true;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (!primes[i]) {
                System.out.println(i + " ");
            }
        }
    }
}
