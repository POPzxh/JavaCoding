# 932. Beautiful Array

For some fixed `N`, an array `A` is *beautiful* if it is a permutation of the integers `1, 2, ..., N`, such that:

For every `i < j`, there is **no** `k` with `i < k < j` such that `A[k] * 2 = A[i] + A[j]`.

Given `N`, return **any** beautiful array `A`. (It is guaranteed that one exists.)

**Example 1:**

```
Input: 4
Output: [2,1,4,3]
```

**Example 2:**

```
Input: 5
Output: [3,1,2,5,4]
```

**Note:**

- `1 <= N <= 1000`

### 思路

要使A[k] != A[i] + A[j]，就要使A[i]和A[j]为**一奇一偶**。[奇数] [偶数]。

然后，需要保证奇数数列和偶数序列也保持，就用递归实现，将奇数位放在偶数位之前。

```java
class Solution {
    public int[] beautifulArray(int N) {
        int[] arr = new int[N];
        for(int i = 1 ; i<= N ;i++)
            arr[i-1] = i;
        beauty(arr , 0 , N-1);
        return arr;
    }
    
    public void beauty(int[] arr , int lo ,int hi){
        if(lo+1 >= hi) return;
        int odd = lo;
        for(int i = 2 ;i<= hi-lo+1 ;i++){
            if(i%2==1){
                int pre = lo + i -2;
                while(odd < pre){
                    int temp = arr[pre+1];
                    arr[pre+1] = arr[pre];
                    arr[pre] = temp;
                    pre--;
                }
                odd++;
            }
        }
        beauty(arr , lo , odd);
        beauty(arr , odd+1 , hi);
    }

}
```

