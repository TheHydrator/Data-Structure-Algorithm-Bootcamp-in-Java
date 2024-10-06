public class NumbersExample {
    public static void main(String[] args) {
        //write the function that takes in a number nf prints it.
        // print first 5 numbers: 1 2 3 4 5
        number(1);
    }
//    static void number(int n){
//        System.out.println(n);
//        number2(2);
//    }
//    static void number2(int n){
//        System.out.println(n);
//        number3(3);
//    }
//    static void number3(int n){
//        System.out.println(n);
//        number4(4);
//    }
//    static void number4(int n){
//        System.out.println(n);
//        number5(5);
//    }
//    // function body here changes.
//    static void number5(int n){
//        System.out.println(n);
//    }
    // we can write the same function as above by recursion.
    static void number(int n){
        if (n == 5){
            System.out.println(5);
            return;
        }
        System.out.println(n);
        //this is called tail recursion.
        // this is the last function call.
        number(n+1);
    }
}
