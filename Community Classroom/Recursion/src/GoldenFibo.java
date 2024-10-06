public class GoldenFibo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(fibonacciFormula(i));
        }
    }
    static int fibonacciFormula(int n){
        if(n<2){
            return n ;
        }
        return (int) ((Math.pow(((1 + Math.sqrt(5)) / 2), n))/ Math.sqrt(5));


    }
}
