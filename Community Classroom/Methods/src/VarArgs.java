import java.util.Arrays;

public class VarArgs {
    public static void main(String[] args){
        fun(2,243,32,23,3,445);
    }
    static void fun(int ...V){
        System.out.println(Arrays.toString(V));
    }
}
