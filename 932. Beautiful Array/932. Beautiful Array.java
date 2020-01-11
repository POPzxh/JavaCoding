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