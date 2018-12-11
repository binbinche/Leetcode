public class solution105 {
    /**根据一棵树的前序遍历与中序遍历构造二叉树。
     注意:
     你可以假设树中没有重复的元素。
     例如，给出
     前序遍历 preorder = [3,9,20,15,7]
     中序遍历 inorder = [9,3,15,20,7]
     返回如下的二叉树：
       3
     / \
     9  20
     /  \
     15   7
     * */
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
    public TreeNode buildTree(int[] preorder,int []inorder){
        if(preorder==null ||inorder==null|| preorder.length==0)
            return null;
        return buildCore(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    private TreeNode buildCore(int[] preorder, int preSt,int preEnd,int[] inorder,int inSt,int inEnd){
        //构建根节点
        int rootValue = preorder[preSt];
        TreeNode root = new TreeNode(rootValue);
        if(preSt == preEnd){
            return root;
        }
        //遍历中序序列中根节点的位置
        int rootIndex = inSt;
        while(inorder[rootIndex]!= rootValue && rootIndex<=inEnd){
            rootIndex++;
        }
        //左子树的长度
        int leftlength = rootIndex- inSt;
        int leftPreEnd = preSt + leftlength;
        //递归生成左子树
        if(leftlength>0){
            root.left = buildCore(preorder,preSt+1,leftPreEnd,inorder,inSt,rootIndex-1);
        }
        if(leftlength< preEnd-preSt)
            root.right = buildCore(preorder,leftPreEnd-1,preEnd,inorder,rootIndex+1,inEnd);
        return root;
    }
}
