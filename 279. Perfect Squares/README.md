# 279. Perfect Squares

Given a positive integer *n*, find the least number of perfect square numbers (for example, `1, 4, 9, 16, ...`) which sum to *n*.

**Example 1:**

```
Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
```

**Example 2:**

```
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
```

### 思路

**动态规划**：维护`dp[i]`数组：数字i的最小数字。

`dp[i] = min(dp[i - 1^2 ~ sqrt(i)^2]) + 1`

```java
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n +1];
        for(int i = 1 ;i<= n ; i++){
            int base = (int) Math.floor(Math.sqrt(i));
            if(base * base == i) dp[i] = 1;
            else {
                int min = Integer.MAX_VALUE;
                for(int b = 1 ; b <= base ; b++){
                    if(1 + dp[i-b*b] < min) min = 1+dp[i-b*b];
                }
                dp[i] = min;
            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[n];        
    }
}
```


