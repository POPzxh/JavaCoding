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