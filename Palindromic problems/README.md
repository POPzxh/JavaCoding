## 516. Longest Palindromic Subsequence

Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

**Example 1:**
Input:

```
"bbbab"
```

Output:

```
4
```

One possible longest palindromic subsequence is "bbbb".

**Example 2:**
Input:

```
"cbbd"
```

Output:

```
2
```

One possible longest palindromic subsequence is "bb".

思路：

维护`dp[i][j]`代表在[i,j]间的最长回文字串。

如果，charAt(i) == charAt(j)，`dp[i][j]=dp[i+1][j-1]+2`。不然，`dp[i][j] = Math.max(dp[i][j-1] , dp[i+1][j]);`



```java
class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if(len == 0) return 0;
        int max = 1;
        int[][] dp = new int[len][len];
        for(int i = 0 ; i < len ;i++){
            dp[i][i] = 1;
            for(int j = i-1 ; j >= 0 ; j--){
                if(s.charAt(j) == s.charAt(i)){
                    dp[j][i] =  dp[j+1][i-1]+2;
                }else dp[j][i] = Math.max(dp[j][i-1] , dp[j+1][i]);
                max = Math.max(max,dp[j][i]);
            }
        }
        return max;
    }
}
```


