# 530. Minimum Absolute Difference in BST

Given a binary search tree with non-negative values, find the minimum [absolute difference](https://en.wikipedia.org/wiki/Absolute_difference) between values of any two nodes.

**Example:**

```
Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
```

### 思路

使用**中序遍历**遍历BST——得到顺序数组。

#### 使用栈遍历

```java
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
```

### 使用递归

```java
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
```

