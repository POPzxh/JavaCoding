# 191. Number of 1 Bits

Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the [Hamming weight](http://en.wikipedia.org/wiki/Hamming_weight)).

**Example 1:**

```
Input: 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
```

**Example 2:**

```
Input: 00000000000000000000000010000000
Output: 1
Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
```

**Example 3:**

```
Input: 11111111111111111111111111111101
Output: 31
Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
```

### 思路

#### 按位与

```java
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int i = 1;
        int ct = 0;
        for(int j = 0 ;j< 32 ;j++){
            if((i & n) == i) ct++;
            i<<=1;
        }
        return ct;
    }
}
```

* **n & (n-1)**可以消除最右边的**1**

```java
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ct = 0;
        while(n != 0){
            n &= (n-1);
            ct++;
        }
        return ct;
    }
}
```

