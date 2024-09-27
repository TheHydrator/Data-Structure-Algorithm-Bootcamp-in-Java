public class Nto1 {
    public static void main(String[] args) {
//       funReverse(5);
//        normal(1);
        funBoth(5);
    }

     static void funBoth(int i) {
        if (i == 0){
            return;
        }
        System.out.println(i); // prints 5 4 3 2 1
        funBoth(i-1 );
        if(i == 1){
            return;
        }
        System.out.println(i); // prints 1 2 3 4 5
    }

    static void fun(int n){
        if (n  == 6){
            return;
        }
        System.out.println(n);
        fun(n-1);
        
    }
    static void funReverse(int n){
        if (n  == 0){
            return;
        }
        System.out.println(n);
        funReverse(n-1);
        System.out.println(n);

    }
    // my method
    static void normal(int n){
        if(n == 6){
            return;
        }
        System.out.println(n);
        normal(n+1);
    }
}
