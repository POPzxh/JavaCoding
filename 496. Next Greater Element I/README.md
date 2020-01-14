# 496. Next Greater Element I

You are given two arrays **(without duplicates)** `nums1` and `nums2` where `nums1`’s elements are subset of `nums2`. Find all the next greater numbers for `nums1`'s elements in the corresponding places of `nums2`.

The Next Greater Number of a number **x** in `nums1` is the first greater number to its right in `nums2`. If it does not exist, output -1 for this number.

**Example 1:**

```
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
```

**Example 2:**

```
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
```

```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
                Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ;i < nums2.length ; i++){
            int nextGreater = -1;
            for(int j = i+ 1 ; j<nums2.length ; j++){
                if(nums2[j] > nums2[i]){
                    nextGreater = nums2[j];break;
                }
            }
            map.put(nums2[i] , nextGreater);
        }
        for(int i = 0 ;i<nums1.length ; i++){
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}
```

* 使用栈，没遍历一个**nums2[i]**与栈顶元素比较，大于则在map中添加，小于则加入栈。保证栈维持一个递减序列。

```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer , Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int num : nums2){
            while(!stack.isEmpty() && num > stack.peek()){
                map.put(stack.pop() , num);
            }
            stack.push(num);
        }
        for(int i = 0 ; i< nums1.length ;i++){
            nums1[i] = map.getOrDefault(nums1[i] , -1);
        }
        return nums1;
    }
}
```

