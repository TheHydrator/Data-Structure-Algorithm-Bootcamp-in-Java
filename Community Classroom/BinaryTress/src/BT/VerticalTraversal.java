package BT;

import java.util.*;

class VerticalTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        VerticalTraversal obj = new VerticalTraversal();
        List<List<Integer>> result = obj.verticalTraversal(root);
        System.out.println(result);
    }
    public List<List<Integer>> verticalTraversal(TreeNode node) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        if (node == null) {
            return ans;
        }

        int col = 0;

        Queue<Map.Entry<TreeNode, Integer>> queue = new ArrayDeque<>();
        Map<Integer, ArrayList<Integer>> map = new HashMap();

        queue.offer(new AbstractMap.SimpleEntry<>(node, col));

        int min = 0;
        int max = 0;

        while(!queue.isEmpty()) {
            Map.Entry<TreeNode, Integer> removed = queue.poll();
            node = removed.getKey();
            col = removed.getValue();

            if(node != null) {
                if(!map.containsKey(col)) {
                    map.put(col, new ArrayList<Integer>());
                }

                map.get(col).add(node.value);

                min = Math.min(min, col);
                max = Math.max(max, col);

                queue.offer(new AbstractMap.SimpleEntry<>(node.left, col-1));
                queue.offer(new AbstractMap.SimpleEntry<>(node.right, col+1));
            }
        }

        for(int i=min; i <= max; i++) {
            ans.add(map.get(i));
        }

        return ans;
    }

}
