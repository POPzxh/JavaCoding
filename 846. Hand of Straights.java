import java.util.TreeMap;

class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        int par = 0;
        if(hand.length == 0|| hand.length % W != 0) return false;
        par = hand.length / W;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num : hand){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }
        for(int i = 0 ;i<par ;i++){
            int first = map.firstKey();
            for(int j = first ; j< first + W ;j++){
                if(!map.containsKey(j)) return false;
                int ct = map.get(j)-1;
                if(ct == 0) map.remove(j);
                else map.replace(j , ct);
            }
        }
        return true;
    }
}