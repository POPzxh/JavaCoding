# 650. 2 Keys Keyboard

Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:

1. `Copy All`: You can copy all the characters present on the notepad (partial copy is not allowed).
2. `Paste`: You can paste the characters which are copied **last time**.

Given a number `n`. You have to get **exactly** `n` 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get `n` 'A'.

**Example 1:**

```
Input: 3
Output: 3
Explanation:
Intitally, we have one character 'A'.
In step 1, we use Copy All operation.
In step 2, we use Paste operation to get 'AA'.
In step 3, we use Paste operation to get 'AAA'.
```

### 1.动态规划

维护数组`dp[i][j]`：达到字符数i，拷贝数j最小步数。
$$
dp[i][j] = min_{j<i/2}(dp[i-j][j]) + 1
$$

```java
class Solution {
    public int minSteps(int n) {
        int[][] dp = new int[n+1][n+1];
        dp[1][1] = 1;
        for(int i = 2 ;i <=n ; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1 ; j <= i/2 ; j++ ){
                if(dp[i-j][j]==0) continue;
                dp[i][j] = dp[i-j][j]+1;
                min = Integer.min(min , dp[i][j]);
            }
            if(i==n) return min;
            dp[i][i] = min + 1;
        }
        return 0;
    }
}
```

### 2.素数分解

要得到n个'A'，需要经过多次拷贝（C）和粘贴（P）。CPPPP..CPP..CPP.......。我们可以将一次粘贴看成一个部分。P1 * P2 * P3... = n。(Pi: 这一部分一次拷贝+粘贴的次数)。显然，如果Pi为合数，可以继续拆分，所以n一定能化为素数的乘积。

return n的质因子的和。

```java
class Solution {
    public int minSteps(int n) {
         int d = 2;
        int ans = 0;
        while(n!=1){
            if(n % d == 0){
                ans += d;
                n /= d;
            }
            else d++;
        }
        return ans;
    }
}
```

