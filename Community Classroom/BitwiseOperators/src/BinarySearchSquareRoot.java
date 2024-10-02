public class BinarySearchSquareRoot {
    public static void main(String[] args) {
        int n = 40;
        int precisionValue = 3; // how many number of decimals do we want
        System.out.printf("%.3f",sqrt(n, precisionValue));

    }
    // TIME: O(log(n))
    static double sqrt (int n, int precisionValue) {
        int start = 0;
        int end = n;

        double root = 0.0;

        while(start<=end){
            int mid = start + (end-start)/2;
            if(mid*mid == n){
                return mid ;
            }
            if(mid * mid > n){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        double increment = 0.1;
        for (int i = 0; i < precisionValue; i++) {
            while(root * root <= n){
                root += increment;
            }
            root = root - increment; // subtract the root when value is more than the square root
            increment = increment/10; // for 0.1 and then 0.01 and then 0.001 likewise
        }

        return root;


    }


}
