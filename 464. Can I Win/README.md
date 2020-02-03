# 464. Can I Win

In the "100 game," two players take turns adding, to a running total, any integer from 1..10. The player who first causes the running total to reach or exceed 100 wins.

What if we change the game so that players cannot re-use integers?

For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until they reach a total >= 100.

Given an integer `maxChoosableInteger` and another integer `desiredTotal`, determine if the first player to move can force a win, assuming both players play optimally.

You can always assume that `maxChoosableInteger` will not be larger than 20 and `desiredTotal` will not be larger than 300.

**Example**

```
Input:
maxChoosableInteger = 10
desiredTotal = 11

Output:
false

Explanation:
No matter which integer the first player choose, the first player will lose.
The first player can choose an integer from 1 up to 10.
If the first player choose 1, the second player can only choose integers from 2 up to 10.
The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
Same with other integers chosen by the first player, the second player will always win.
```

### 思路

如果我方必定能赢得比赛，那么意味着，1）选取的数字>= `desiredTotal` 2）选取数字后，对于对方， `desiredTotal-i`肯定输。那么，怎么判断肯定输呢？就是不管选取什么数字，对方肯定赢。很明显，就转化为了递归问题。

```java
class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger >= desiredTotal) return true;
        if((maxChoosableInteger + 1) * maxChoosableInteger/2 < desiredTotal) return false;
        int[] map = new int[1 << maxChoosableInteger + 1];
        return caniwin(maxChoosableInteger , desiredTotal , map , 0);
    }

    public boolean caniwin(int upper , int desiredTotal , int[] map, int used){
        if(map[used] != 0) return map[used] == 1;
        for(int i = 1 ; i<= upper ; i++){
            if((used & (1<<i)) == 0){
                if(i >= desiredTotal || ! caniwin(upper , desiredTotal - i , map , used | (1<<i))){
                    map[used] = 1;
                    return true;
                }
            }
        }
        map[used] = -1;
        return false;
    }
}
```

使用记忆化搜索避免重复递归。


