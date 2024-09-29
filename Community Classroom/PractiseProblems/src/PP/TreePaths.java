package PP;

import java.util.ArrayList;
import java.util.List;


public class TreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null){
            return null;
        }
        String current_path = Integer.toString(root.val);
        if(root.left == null && root.right == null){
            result.add(current_path);
        }
        if(root.left != null) {
            dfs(root.left, current_path, result);
        }
        if(root.right != null) {
            dfs(root.right, current_path, result);
        }
        return result;
    }

    public void dfs(TreeNode node, String current_path, List<String> result){
        current_path = current_path + "->" + node.val;
        if(node.left == null && node.right == null){
            result.add(current_path);
            return;
        }
        if(node.left != null) {
            dfs(node.left, current_path, result);
        }
        if(node.right != null) {
            dfs(node.right, current_path, result);
        }
    }

    // more optimized solutions by using backTrack

    public List<String> binaryTreePath(TreeNode root){
        List<String> answer = new ArrayList<>();
        depthFirstSearch(root, new StringBuilder(), answer);
        return answer;
    }

    private void depthFirstSearch(TreeNode node, StringBuilder path, List<String> answer) {
        if(node == null){
            return;
        }
        int length = path.length(); // "1->2->5" length = 3, "1->2" length = 2
        if(length > 0){
            path.append("->");
        }
        path.append(node.val);

        if(node.left == null && node.right == null){ // means it's the leaf node
            answer.add(path.toString());
        }else{
            depthFirstSearch(node.left, path, answer);
            depthFirstSearch(node.right, path, answer);
        }
        path.setLength(length); // BackTrack by resetting the stringBuilder
    }
    //depthFirstSearch(node = 1, path = "", answer = [])
    //  path = "1"
    //  DFS(node = 2, path = "1->", answer = [])
    //    path = "1->2"
    //    DFS(node = 5, path = "1->2->", answer = [])
    //      path = "1->2->5"
    //      (leaf node, add "1->2->5" to answer)
    //      Backtrack: path = "1->2"
    //    Backtrack: path = "1"
    //  DFS(node = 3, path = "1->", answer = ["1->2->5"])
    //    path = "1->3"
    //    (leaf node, add "1->3" to answer)
    //    Backtrack: path = "1"

}
