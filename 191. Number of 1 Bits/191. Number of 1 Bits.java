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

//* **n & (n-1)**可以消除最右边的**1**
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

