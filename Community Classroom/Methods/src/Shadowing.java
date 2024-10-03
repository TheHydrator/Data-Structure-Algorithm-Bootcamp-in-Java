public class Shadowing {
    static int x = 80;
    public static void main(String[]args){
        System.out.println(x);
        int x;//declaring the variable
        x = 40;// initializing the variable.
        System.out.println(x);
        fun();
    }
    static void fun(){
        System.out.println(x);
    }
}
