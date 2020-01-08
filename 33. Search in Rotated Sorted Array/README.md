# 33. Search in Rotated Sorted Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., `[0,1,2,4,5,6,7]` might become `[4,5,6,7,0,1,2]`).

You are given a target value to search. If found in the array return its index, otherwise return `-1`.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of *O*(log *n*).

**Example 1:**

```
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```

**Example 2:**

```
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
```

### 思路

类似于二问查找**Binary Search**。这道题将一个增序数列(没有重复值)的一部分移动到后面。

如，`[0,1,2,4,5,6,7]` 中移动`[0,1,2]`到后面 `[4,5,6,7,0,1,2]`).

所以这道题的关键是：找到**分割点**：`nums[mid] > nums[hi]`: 分割点在mid的右边，否则在左边

```java
class Solution {
    public int search(int[] nums, int target) {
        int find = -1;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi && find == -1){
            if(nums[lo] == target) return lo;
            if(nums[hi] == target) return hi;
            int mid = (lo + hi) / 2;
            if(nums[mid] == target) find = mid;
            if(nums[mid] > nums[hi]){
                if(target > nums[lo] && target < nums[mid]) hi = mid-1;
                else lo = mid + 1;
            }else{
                if(target > nums[mid] && target < nums[hi]) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return find;
    }
}
```

