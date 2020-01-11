//使用栈
class Solution {
    int min = Integer.MAX_VALUE;
    int pre = Integer.MAX_VALUE;
    public void preBST(TreeNode node){
        if(node != null){
            preBST(node.left);
            min = Math.min(min , Math.abs(pre - node.val));
            pre = node.val;
            preBST(node.right);
        }
    }

    public int getMinimumDifference(TreeNode root) {
        preBST(root);
        return min;
    }
}
//不适用栈
class Solution {
    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int min = Integer.MAX_VALUE;
        int pre = Integer.MAX_VALUE;
        while(!stack.isEmpty() || root!=null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            min = Math.min(min , Math.abs(pre - cur.val));
            pre = cur.val;
            root = cur.right;
        }
        return min;
    }
}
