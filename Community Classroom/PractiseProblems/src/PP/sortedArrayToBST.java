package PP;

class sortedArrayToBST {
    public TreeNode SortedArrayToBST(int[] nums){
        return SortedArrayToBST(nums, 0, nums.length);
    }
 // use the binary search method in thr tree.
    private TreeNode SortedArrayToBST(int[] nums, int start, int end) {
        if(start >= end){
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = SortedArrayToBST(nums, start, mid - 1);
        node.right = SortedArrayToBST(nums, mid + 1, end);
        return node;
    }
}
