import java.util.Arrays;

public class Methods {
    public static void main(String[] args) {
        String name = "Rohit Maity Hello world";
        System.out.println(Arrays.toString(name.toCharArray()));
        System.out.println(name.toLowerCase());
        System.out.println(Arrays.toString(name.toCharArray()));
        System.out.println("    Rohit    ".strip());
        System.out.println(Arrays.toString(name.split(" ")));

    }
}
