public class Stream {
    public static void main(String[] args) {
        System.out.println(skipAppNotApple("bdaappliedfg"));
    }
    static void skip(String processed, String unProcessed ){
        if(unProcessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch = unProcessed.charAt(0); // taking every first character
        if (ch == 'a'){
            // skip it
            skip( processed , unProcessed.substring(1));
        }else{
            // dont skip it.
            skip(processed + ch, unProcessed.substring(1));

        }
    }

    static String skip(String unProcessed ){
        if(unProcessed.isEmpty()){
            return " ";
        }
        char ch = unProcessed.charAt(0); // taking every first character
        if (ch == 'a'){
            // skip it
            return skip( unProcessed.substring(1));
        }else{
            // dont skip it.
            return ch + skip(unProcessed.substring(1));

        }
    }

    static String skipApple(String up ){
        if(up.isEmpty()){
            return " ";
        }
        if (up.startsWith("apple")){
            // skip it
            return skipApple( up.substring(5)); // apple = 5
        }else{
            // dont skip it.
            return up.charAt(0) + skipApple(up.substring(1)); // any other words are 1 letter.

        }
    }

    static String skipAppNotApple(String up){
        if (up.isEmpty()) {
            return " ";
        }
        if(up.startsWith("app") && !up.startsWith("apple")){
            // skip it.
            return skipAppNotApple(up.substring(3));
        }
        return up.charAt(0) + skipAppNotApple(up.substring(1));
    }
}
