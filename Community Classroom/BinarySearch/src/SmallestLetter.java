public class SmallestLetter{
    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return letters[start % letters.length];
    }

    public static void main(String[] args) {
        char[] lettersArray = {'a', 'c', 'f', 'h'};
        char targetLetter = 'd';

        char result = nextGreatestLetter(lettersArray, targetLetter);

        System.out.println("Next greatest letter to " + targetLetter + " is: " + result);
    }
}




