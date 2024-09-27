import java.util.ArrayList;

public class PhonePad {
    public static void main(String[] args) {
        mobilePad("", "12");
        System.out.println(mobilePadRet("", "12"));
        System.out.println(mobilePadCount("", "12"));
    }
    static void mobilePad(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0'; // this will convert '1' into 1 and '2' into 2

        for (int i = (digit - 1) * 3 ; i < digit * 3; i++) {
            char ch = (char) ('a' + i); // a+0 = a, a+1 = b, similarly upto z.
            mobilePad(p + ch, up.substring(1));
        }
    }

    // Return the above answer in an ArrayList.

    static ArrayList<String> mobilePadRet(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0'; // this will convert '1' into 1 and '2' into 2
        ArrayList<String> list = new ArrayList<>();

        for (int i = (digit - 1) * 3 ; i < digit * 3; i++) {
            char ch = (char) ('a' + i); // a+0 = a, a+1 = b, similarly upto z.
            list.addAll(mobilePadRet(p + ch, up.substring(1)));
        }
        return list;
    }

    // Returning the count for the ArrayList.

    static int mobilePadCount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }

        int digit = up.charAt(0) - '0'; // this will convert '1' into 1 and '2' into 2
        int count = 0;

        for (int i = (digit - 1) * 3 ; i < digit * 3; i++) {
            char ch = (char) ('a' + i); // a+0 = a, a+1 = b, similarly upto z.
            count = count + mobilePadCount(p + ch, up.substring(1));
        }
        return count;
    }
}
