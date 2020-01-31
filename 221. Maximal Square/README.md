# 221. Maximal Square

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

**Example:**

```
Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
```

## 方法一： 暴力循环

从**min(m,n)~1**全部遍历。能过

```java
class Solution {
    public int maximalSquare(char[][] matrix) {
        int hi = matrix.length;
        if(hi == 0) return 0;
        int wi = matrix[0].length;
        int ans = Math.min(hi,wi);
        while(ans>0){
            for(int i = 0 ; i + ans<=hi ; i++){
                for(int j = 0 ; j + ans <= wi ; j++){
                    boolean allone = true;
                    for(int x = i ;x < i + ans && allone; x++){
                        for(int y = j; y < j + ans && allone; y ++){
                            if(matrix[x][y] == '0') allone = false; 
                        }
                    }
                    if(allone) {
                        return ans*ans;
                    }
                }
            }
            ans--;
        }
        return 0;
    }
}
```

## 方法二： 动态规划

**Algorithm**

We will explain this approach with the help of an example.

```
0 1 1 1 0
1 1 1 1 1
0 1 1 1 1
0 1 1 1 1
0 0 1 1 1
```

We initialize another matrix (dp) with the same dimensions as the original one initialized with all 0’s.

dp(i,j) represents the side length of the maximum square whose bottom right corner is the cell with index (i,j) in the original matrix.
$$
dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1.
$$
Starting from index (0,0), for every 1 found in the original matrix, we update the value of the current element as

We also remember the size of the largest square found so far. In this way, we traverse the original matrix once and find out the required maximum size.

To understand how this solution works, see the figure below.

![Max Square](https://leetcode.com/media/original_images/221_Maximal_Square.PNG?raw=true)

An entry 2 at (1, 3)(1,3) implies that we have a square of side 2 up to that index in the original matrix. Similarly, a 2 at (1, 2)(1,2) and (2, 2)(2,2) implies that a square of side 2 exists up to that index in the original matrix. Now to make a square of side 3, only a single entry of 1 is pending at (2, 3)(2,3). So, we enter a 3 corresponding to that position in the dp array.

Now consider the case for the index (3, 4)(3,4). Here, the entries at index (3, 3)(3,3) and (2, 3)(2,3) imply that a square of side 3 is possible up to their indices. But, the entry 1 at index (2, 4)(2,4) indicates that a square of side 1 only can be formed up to its index. Therefore, while making an entry at the index (3, 4)(3,4), this element obstructs the formation of a square having a side larger than 2. Thus, the maximum sized square that can be formed up to this index is of size 2\times22×2.

```java
class Solution {
    public int maximalSquare(char[][] matrix) {       
        int hi = matrix.length;
        if(hi == 0) return 0;
        int wi = matrix[0].length;
        int[][] dp =new int[hi][wi];
        int max = 0;
        for(int i = 0 ; i < hi ; i++){
            for(int j = 0 ; j < wi ; j++){
                if(matrix[i][j] == '1'){
                    if(i==0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = Math.min(dp[i-1][j] , dp[i][j-1]) +1;
                }
                if(dp[i][j] > 1){
                   int temp = dp[i][j];
                   if(matrix[i-temp+1][j-temp+1] != '1') dp[i][j]--;
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max*max;
    }
}
```

