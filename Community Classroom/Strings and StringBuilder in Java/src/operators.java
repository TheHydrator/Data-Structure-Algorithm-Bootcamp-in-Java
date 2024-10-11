import java.util.ArrayList;

public class operators {
    public static void main(String[] args) {
        System.out.println('a' + 'b');
        System.out.println("A"+"B");
        System.out.println((char)('a'+3));
        System.out.println("a" + 1);
        System.out.println("Rohit"+ new ArrayList<>());
        System.out.println("Rohit"+ 56);
        // there needs to be a  string type value to add in the complex data types otherwise it will give errors.
        // primitives and concatenating more than one string.
        System.out.println(56 +"" +new ArrayList<>());
    }

}
