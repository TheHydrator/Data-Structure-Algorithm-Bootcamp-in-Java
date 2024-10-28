public class EvenDigits {
    public static void main(String[] args) {
        int[] number = {12, 345, 2, 4, -7896, -69};
        System.out.println(findNumbers(number));
//        System.out.println(digits(-234566));
    }
    static int findNumbers(int[] nums){
        int count = 0;
        for(int num : nums){
            if(even(num)) {
                count++;
            }
        }
        return count;

    }
    //function to check whether a number contains even number of digits or not.
    static boolean even(int num){
        int numberOfDigits = digits2(num);
        /*if (numberOfDigits % 2== 0){
        //            return true;
        //        }
        //        return false;

         */
        return numberOfDigits % 2 == 0;
    }

// count number of digits in a number
    static int digits (int num) {
        if (num<0){
            num = num * -1;
        }
        if (num == 0){
            return 1;
        }
        int count = 0;
        while(num > 0) {
            count++;
            num = num / 10;
    }
        return count;
}

// For optimized solutions.
    static int digits2(int num){
        if (num < 0) {
            num = num * -1;
        }
        return (int)(Math.log10(num)) + 1;
    }

}
