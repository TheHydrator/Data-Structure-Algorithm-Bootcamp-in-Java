import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
//        permutation("", "ABC");
        ArrayList<String> ans = permutationList("", "ABC");
        System.out.println(ans);
        System.out.println(permutationCount("", "ABC"));
    }
    static void permutation(String p , String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++) {
            String first = p. substring(0, i); // (0 to i - 1)
            String second = p.substring(i, p.length()); // (i till length - 1)
            permutation(first + ch + second, up.substring(1));
        }
    }

    //returning output as an ArrayList.

    static ArrayList<String> permutationList(String p , String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i <= p.length(); i++) {
            String first = p. substring(0, i); // (0 to i - 1)
            String second = p.substring(i, p.length()); // (i till length - 1)
            ans.addAll(permutationList(first + ch + second, up.substring(1)));
        }

        return ans;
    }

    //permutation count.

    static int permutationCount(String p , String up){
        if(up.isEmpty()){
            return 1;
        }
        char ch = up.charAt(0);
        int count = 0;

        for (int i = 0; i <= p.length(); i++) {
            String first = p. substring(0, i); // (0 to i - 1)
            String second = p.substring(i, p.length()); // (i till length - 1)
            count = count + permutationCount(first + ch + second, up.substring(1));
        }
        return count;
    }
}
