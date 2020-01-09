# 861. Score After Flipping Matrix

We have a two dimensional matrix `A` where each value is `0` or `1`.

A move consists of choosing any row or column, and toggling each value in that row or column: changing all `0`s to `1`s, and all `1`s to `0`s.

After making any number of moves, every row of this matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.

Return the highest possible score.

**Example 1:**

```
Input: [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
Output: 39
Explanation:
Toggled to [[1,1,1,1],[1,0,0,1],[1,1,1,1]].
0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
```

**Note:**

1. `1 <= A.length <= 20`
2. `1 <= A[0].length <= 20`
3. `A[i][j]` is `0` or `1`.

### 思路

1）先处理每一行，如果`row[0] == 0`就将这一行翻转。

2）再处理每一列，如果某一列的1的个数小于0的个数，就翻转这一列。

```java
class Solution {
    public int matrixScore(int[][] A) {
        for(int[] row : A){
            if(row[0] == 0){
                for(int i= 0 ;i<row.length ;i++){
                    if(row[i] == 1) row[i] = 0;
                    else row[i] = 1;
                }
            }
        }
        int sum = 0;
        int total = A.length;
        for(int i = 0 ;i<A[0].length ;i++){
            int oneSum = 0;
            for(int j = 0; j < A.length ;j++){
                oneSum += A[j][i];
            }
            if(oneSum <= total / 2) oneSum = total - oneSum;            
            sum += (1<<(A[0].length - i -1)) * oneSum;
        }
        return sum;
    }
}
```

