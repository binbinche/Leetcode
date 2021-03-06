package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class maxAncestorDiff {
	/**5030. 节点与其祖先之间的最大差值  显示英文描述  
给定二叉树的根节点 root，找出存在于不同节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。

（如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）

示例：
输入：[8,3,10,1,6,null,14,null,null,4,7,13]
输出：7
解释： 
我们有大量的节点与其祖先的差值，其中一些如下：
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。

提示：
树中的节点数在 2 到 5000 之间。
每个节点的值介于 0 到 100000 之间。*/
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x ){
            val = x;
        }
    }
    public int solution5030(TreeNode root){
        if(root ==null)
            return 0;
        return maxdiff(root, root.val, root.val);
    }
    public int maxdiff(TreeNode root, int min, int max){
        if(root==null)
            return 0;
        int res = Math.max(Math.abs(root.val-min), Math.abs(root.val-max));
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        int left = maxdiff(root.left, min,max);
        int right = maxdiff(root.right,min,max);
        return Math.max(res, Math.max(left,right));
    }
    public static void main(String[] args){
        String s = "[8,3,10,1,6,null,14,null,null,4,7,13]";
        TreeNode root = stringToTreeNode(s);
        maxAncestorDiff func = new maxAncestorDiff();
        System.out.println(func.solution5030(root));
    }
}
