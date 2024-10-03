public class Scope {
    public static void main(String[] args){
        int a = 10;
        int b = 20;
        String name = "Rohit";
        {
            a = 100;//reassign the original ref variable to some other value.
            name = "Rahul";
            System.out.print(a + " " + name );
        }
        System.out.print(a);
    }

}
