public class Concept {
    public static void main(String[] args) {
        funConcept(10);
    }
    static void funConcept (int n){
        if (n == 0){
            return ;
        }
        System.out.println(n);
//        fun(n--);
        funConcept(--n);
    }
}
