## 421. Maximum XOR of Two Numbers in an Array

Given a **non-empty** array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

Find the maximum result of ai XOR aj, where 0 ≤ *i*, *j* < *n*.

Could you do this in O(*n*) runtime?

**Example:**

```
Input: [3, 10, 5, 25, 2, 8]

Output: 28

Explanation: The maximum result is 5 ^ 25 = 28.
```

```java
class Solution {
    public int findMaximumXOR(int[] nums) {
        int mask = 0;
        int max = 0;
        for(int i = 31 ; i>=0 ; i--){
            mask |= 1<<i;
            HashSet<Integer> prefixs = new HashSet<>();
            for(int num : nums) prefixs.add(num & mask);
            //prefix1 ^ max = prefix2
            //check whether pos i is 1 or 0
            for(int prefix : prefixs){
                if(prefixs.contains(prefix ^ (max | 1<<i))){
                    max |= 1<<i;
                    break;
                }
            }
        }
        return max;
    }
}
```

根据异或的性质：如果a ^ b = c，则必然a ^ c =b。