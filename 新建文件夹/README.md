# 503. Next Greater Element II

Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

**Example 1:**

```
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; The number 2 can't find next greater number; The second 1's next greater number needs to search circularly, which is also 2.
```

**Note:** The length of given array won't exceed 10000.

### 思路：

使用栈维护一个递增序列，栈底是nums[i]~nums[length-1]中中最大的数，栈保存nums[i+1]~nums[max]的递增序列。

所以，从后往前遍历，如果nums[i] < top, 就说明nums[i]的next greater element就是top。否则，pop直到小于top。

```java
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        boolean[] vis= new boolean[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int step = 0 ; step < 2; step++) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if(vis[i]) continue;
                while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    ans[i] = stack.peek();
                    vis[i] = true;
                    stack.push(nums[i]);
                } else {
                    stack.push(nums[i]);
                    ans[i] = -1;
                }
            }
        }
        return ans;
    }
}
```



