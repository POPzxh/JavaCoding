# 300. Longest Increasing Subsequence

Given an unsorted array of integers, find the length of longest increasing subsequence.

**Example:**

```
Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
```

## 动态规划 O(n<sup>2</sup>)

使用数组`dp[i]`保存以`nums[i]`为结尾的最长子序列。所以状态转移方程为：
$$
dp[i] = min_{j<i,nums[j]<nums[i]}(dp[j])
$$

```java
    public int lengthOfLIS(int[] nums) {
        int len = 0;
        if((len = nums.length) == 0) return 0;
        int[] dp =new int[len];
        dp[0] = 1;
        for(int i = 1 ; i< len ; i++){
            int max = 1;
            for(int j = 0 ; j<i ; j++){
                max = Math.max(max , dp[j]);
            }
            dp[i] = max;
        }
        return dp[len-1];
    }
```

# 动态规划O(nlogn)

现在数组`dp[i]`代表长度为i-1的字串的最后一个数字。即，数组中的每一位都保存着一个字串。因为我们希望字串尽可能的长，所以当nums[i]小于字串末尾的数字时，就将其替换。

```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int longest = 1;
        int[] dp = new int[len+1];
        dp[0] = nums[0];
        for(int i = 1 ; i< len ; i++){
            //在dp中找到nums[i]的位置
            int pos = Arrays.binarySearch(dp , 0 , longest , nums[i]);
            if(pos < 0) {//不在dp中，需要更新某个字串的末尾数
                pos = -pos - 1;//pos为第一个大于nums[i]的位置
                if(pos == longest){
                    //nums[i]大于所有的字串末尾数，延伸字串                    
                    dp[longest] = nums[i];
                    longest++;
                }
                else{
                    //更新末尾数
                    dp[pos] = nums[i];
                }
            }
        }
        return longest;
    }
}
```


