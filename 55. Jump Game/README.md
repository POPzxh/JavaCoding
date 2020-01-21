# 55. Jump Game

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

**Example 1:**

```
Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
```

**Example 2:**

```
Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
```

### 思路

* 动态规划

使用`dp[i]`记录，在位置i处可以到达最远的距离。状态转移方程：`dp[i] = max(dp[i-1] , i +nums[i])`

```java
class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if(dp[0] == 0 && nums.length != 1) return false;
        for(int i = 1 ; i< nums.length-1 ;i++){
            dp[i] = Math.max(dp[i-1] , i + nums[i]);
            if(dp[i] == i) return false;
        }
        return true;
    }
}
```

* 贪心

每次跳跃时，选择尽可能远的点即**Max(i + nums[i])**。如果，位置没有变化则返回**false**

```java
class Solution {
    public boolean canJump(int[] nums) {
        int target = nums.length - 1;
        int cur = 0;
        while(cur <= target){
            if(cur == target) return true;
            int max = Integer.MIN_VALUE;
            int temp = cur;
            for(int i = 1 ; i<= nums[cur] ; i++){
                int next = cur + i;
                if(next > target) next = target;
                if(next+ nums[next] > max){
                    max = next + nums[next];
                    temp = next;
                }
            }
            if(cur == temp) return false;
            cur = temp;
        }
        return false;
    }
}
```


