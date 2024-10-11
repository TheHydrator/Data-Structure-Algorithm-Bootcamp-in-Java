public class Main {
    public static void main(String[] args) {
        String a = "Rohit";
        System.out.println(a);
        a = "Here a new Maity object is created instead of Rohit";
        System.out.println(a);
        String c = a;
        System.out.println(c == a);
    }
}
