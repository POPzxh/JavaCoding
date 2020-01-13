# 1161. Maximum Level Sum of a Binary Tree

Given the `root` of a binary tree, the level of its root is `1`, the level of its children is `2`, and so on.

Return the **smallest** level `X` such that the sum of all the values of nodes at level `X` is **maximal**.

 **Example 1:**

**![img](https://assets.leetcode.com/uploads/2019/05/03/capture.JPG)**

```
Input: [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.
```

 

**Note:**

1. The number of nodes in the given tree is between `1` and `10^4`.
2. `-10^5 <= node.val <= 10^5`

### 思路

很简单，层序遍历二叉树

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        class nodeLevel{
            TreeNode node;
            int level;

            nodeLevel(TreeNode node , int level){this.node = node; this.level = level;};
        }
        Queue<nodeLevel> que = new LinkedList<>();
        int sum = 0;
        int temp = Integer.MIN_VALUE;
        int ans = 0;
        int pre = Integer.MAX_VALUE;
        que.add(new nodeLevel(root , 1));
        while (!que.isEmpty()){
            nodeLevel nL = que.poll();
            TreeNode cur = nL.node;
            int level = nL.level;
            if(level == pre) sum+=cur.val;
            else{
                if(sum > temp){
                    temp = sum;
                    ans = level-1;
                }
                sum = cur.val;
                pre = level;
            }
            if(cur.left!=null) que.add(new nodeLevel(cur.left , level+1));
            if(cur.right!=null) que.add(new nodeLevel(cur.right , level+1));
        }
        return ans;
    }
}
```

```java
class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int level = 1;
        int ans = 1;
        int temp = Integer.MIN_VALUE;
        while (!que.isEmpty()){
            int size  = que.size();
            int sum = 0;
            for(int i = 0 ;i<size;i++){
                TreeNode cur = que.poll();
                if(cur.right != null) que.add(cur.right);
                if(cur.left != null) que.add(cur.left);
                sum += cur.val;
            }
            if(sum > temp){
                temp = sum;
                ans = level;
            }
            level++;
        }
        return ans;
    }
}
```

