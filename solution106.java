public class solution106 {
    /**
     * 根据一棵树的中序遍历与后序遍历构造二叉树。
     * 注意:
     * 你可以假设树中没有重复的元素。
     * 例如，给出
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     * 返回如下的二叉树：
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7*/

    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

    public TreeNode buildTree(int [] inorder,int [] postorder){
        if(inorder==null || postorder == null || postorder.length==0)
            return null;
        return buildCore(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
    }
    private TreeNode buildCore(int[] postorder, int postSt, int postEnd, int[] inorder, int inSt,int inEnd){
        //后序遍历最后一个节点为二叉树的根节点
        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);
        //后序遍历只有根节点
        if(postSt == postEnd)
            return root;
        //中序遍历，找到根节点的位置
        int rootInorder = inSt;
        while(inorder[rootInorder] != rootValue && rootInorder <=inEnd)
            rootInorder++;
        //左子树长度
        int leftLength = rootInorder - inSt;
        // 后序序列中左子树的最后一个节点。
        int leftPostEnd = postSt + leftLength -1;

        //左子树非空，左子树长度大于0
        if(leftLength>0){
            root.left = buildCore(postorder, postSt, leftPostEnd, inorder, inSt,rootInorder-1);
        }
        //右子树非空
        if(leftLength< postEnd - postSt){
            root.right = buildCore(postorder, leftPostEnd +1,postEnd-1,inorder, rootInorder+1,inEnd);
        }
        return root;
    }

}
