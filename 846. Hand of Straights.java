class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        int par = 0;
        if(hand.length == 0|| hand.length % W != 0) return false;
        par = hand.length / W;
        Map<Integer, Integer> map = new TreeMap<>();
        for(int num : hand){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }
        for(int i = 0 ;i<par ;i++){
            int cnt = 0;
            int pre = 0;
            // System.out.println(map);
            Set<Integer> nums = new TreeSet<>(map.keySet());
            for(int num : nums){
                if(cnt != 0){
                    if(num - 1 != pre) return false;
                }
                int ct = map.get(num)-1;
                if(ct == 0) map.remove(num);
                else map.put(num,ct);
                cnt++;
                if(cnt == W) break;
                pre = num;
            }
            if(cnt < W) return false;
        }
        return true;
    }
}