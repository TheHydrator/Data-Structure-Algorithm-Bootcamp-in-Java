package PP;

import java.util.ArrayList;
import java.util.List;

public class SortedListToBST {
    public TreeNode sortedListToBST1(ListNode head){
        if(head == null){
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        while(head != null){
            list.add(head);
            head = head.next;
        }
        return sortedListToBST1(list, 0, list.size() -1);
    }

    private TreeNode sortedListToBST1(List<ListNode> list, int start, int end) {
        if(start > end){
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(list.get(mid).val); // get the middle value.
        sortedListToBST1(list, start, mid - 1);
        sortedListToBST1(list, mid + 1, end);
        return node;
    }
    
    public TreeNode sortedListToBST2(ListNode head){
        if(head == null){
            return null;
        }
        return sortedListToBSTHelper(head, null); // head is the start and null is the end.
    }

    private TreeNode sortedListToBSTHelper(ListNode head, ListNode tail){
        if(head == tail){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // at this point, slow is the middle of the list.
        TreeNode node = new TreeNode(slow.val);
        // recursively call the left and right side of the list.
        node.left = sortedListToBSTHelper(head, slow);
        node.right = sortedListToBSTHelper(slow.next, tail);
        return node;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
