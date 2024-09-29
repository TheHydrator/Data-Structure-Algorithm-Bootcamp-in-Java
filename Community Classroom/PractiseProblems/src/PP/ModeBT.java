package PP;

public class ModeBT {

//    int currentNum = 0;
//    int currentFreq = 0;
//    int maxFreq = 0;
//    int [] result;
//    public int[] findMode(TreeNode root) {
//        dfs(root);
//
//
//        return result;
//    }
//
//    private void dfs(TreeNode node) {
//        if(node == null){
//            return;
//        }
//        /*left recursive call*/
//        dfs(node.left);
//
//        /* process the current node */
//        if(node.val == currentNum){
//            currentFreq++;
//        }else{
//            currentNum = node.val; // update the current number with the new number.
//            currentFreq = 1; // reset the current frequency to 1.
//        }
//
//        if(currentFreq > maxFreq){
//            maxFreq = currentFreq; //update the maxFrequency with the current frequency
//            result = new int[]{currentNum}; // reset the result array with the current number, since it has the highest frequency.
//        }
//
//        if(currentFreq == maxFreq){
//            result = new int[]{currentNum}; // add the current number to the result array, since it has the same frequency as the max frequency.
//        }
//
//        /* right recursive call */
//        dfs(node.right);
//    }
    // more optimized code.
    private TreeNode prev = null; // to track the previous node in-Order traversal.
    private int currentFreq = 0;
    private int maxFreq = 0;
    private int modeCount = 0; // to keep tracks of how many modes we have.
    private int[] modes; // to store the modes.
    public int[] findMode(TreeNode root){
        // first in_order traversal to find the modeCount.
        inOrder(root, true); // true means we are counting the modeCount.
        // second traversal to find the mode.
        modes = new int[modeCount];//  here the modeCount elements are stored in the mode's array.
        modeCount  = 0; // reset the modeCount to 0.
        currentFreq = 0; // reset the current frequency to 0.
        prev = null; // reset the previous node to null.
        // second in_order traversal to find the mode.
        inOrder(root, false); // false means we are finding the mode.
        return modes;
    }

    private void inOrder(TreeNode node, boolean findMaxFreq) {
        if(node == null){
            return;
        }

        inOrder(node.left, findMaxFreq);

        if(prev != null && prev.val == node.val){
            // if the current value is the same as the previous value, then increment the current frequency.
            currentFreq++;
        }else{
            // if the current value is different then the previous value then reset the current frequency to 1.
            currentFreq = 1;
        }

        if(currentFreq > maxFreq){
            // found a new maximum frequency, update maxFreq and reset the modeCount to 1.
            maxFreq = currentFreq;
            modeCount = 1;
        } else if (currentFreq == maxFreq) {
            // current frequency matches the max frequency, add the current value to the findMaxFreq array.
            if(findMaxFreq){
                // First pass: increment the modeCount to determine the size of the mode's array.
                modeCount++;
            }else{
                // Second pass: add the current value to the mode's array.
                modes[modeCount++] = node.val; // modeCount is incremented after the value is added.
            }

        }
        prev = node; // update the previous to the current node before moving to the right subtree.

        inOrder(node.right, findMaxFreq);
    }


}
