# LeetCode 中的 Sum Problems

## 1. Two Sum

Given an array of integers, return **indices** of the two numbers such that they add up to a specific target.

You may assume that each input would have ***exactly\*** one solution, and you may not use the *same* element twice.

**Example:**

```
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

```java
class Solution {
   public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement) && map.get(complement) != i) {
            return new int[] { i, map.get(complement) };
        }
    }
    throw new IllegalArgumentException("No two sum solution");
}
}
```

## 15. 3Sum

Given an array `nums` of *n* integers, are there elements *a*, *b*, *c* in `nums` such that *a* + *b* + *c* = 0? Find all unique triplets in the array which gives the sum of zero.

**Note:**

The solution set must not contain duplicate triplets.

**Example:**

```
Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length-2 ; i++){
            if(i!=0) if(nums[i] == nums[i-1]) continue;
            int target = - nums[i];
            if(target < 0) break;
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi){
                if(lo!=i+1) if(nums[lo]==nums[lo-1]){lo++;continue;}
                if(nums[lo] + nums[hi] == target){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);list.add(nums[lo]);list.add(nums[hi]);                    
                    ans.add(list);
                    lo++;
                }
                else if(nums[lo] + nums[hi] > target) hi--;
                else lo++;
            }
        }
        return ans;
    }
}
```

