## 698. Partition to K Equal Sum Subsets

Given an array of integers `nums` and a positive integer `k`, find whether it's possible to divide this array into `k` non-empty subsets whose sums are all equal.

**Example 1:**

```
Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
```

**Note:**

- `1 <= k <= len(nums) <= 16`.
- `0 < nums[i] < 10000`.

### 思路

将数组分成和相等的k个子数组，首先数组的所有元素之和必须得能被k整除，这样每个子数组需要达到的目标和也就确定了，可以使用深度优先搜索来解决。创建一个bool数组来记录原数组中的元素是否可用，使用sum变量记录当前的和，每次遍历数组，对于可用的元素，使用深度优先搜索判断加上这个元素以后是否能实现partion，如果可以就返回true，否则将当前元素在visited中的对应值改为false。终止情况是 

        1. k==1，这时已经划分完k-1个子数组，由于原数组能被k整除，所以剩下的元素相加一定等于k，返回true
        2. sum==target，此时将k减1，递归

```java
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(k == 1) return true;
        int subSum = 0;
        for(int num : nums) subSum += num;
        Arrays.sort(nums);
        if(subSum % k != 0 || nums[nums.length-1] > subSum/k) return false;
        subSum /= k;
        boolean[] vis = new boolean[nums.length];
        return findPartition(nums , k , vis , subSum , 0);
    }

    public boolean findPartition(int[] nums , int k , boolean[] vis , int subSum , int sum){
        if(sum == subSum){
            if(k == 2) return true;
            return findPartition(nums , k-1 , vis , subSum , 0);
        }
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            if(!vis[i] && nums[i] + sum <= subSum) {
                vis[i] = true;
                if (findPartition(nums, k, vis , subSum , sum + nums[i])) return true;
                vis[i] =false;
            }
        }
        return false;
    }
}
```


