class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger >= desiredTotal) return true;
        if((maxChoosableInteger + 1) * maxChoosableInteger/2 < desiredTotal) return false;
        int[] map = new int[1 << maxChoosableInteger + 1];
        return caniwin(maxChoosableInteger , desiredTotal , map , 0);
    }

    public boolean caniwin(int upper , int desiredTotal , int[] map, int used){
        if(map[used] != 0) return map[used] == 1;
        for(int i = 1 ; i<= upper ; i++){
            if((used & (1<<i)) == 0){
                if(i >= desiredTotal || ! caniwin(upper , desiredTotal - i , map , used | (1<<i))){
                    map[used] = 1;
                    return true;
                }
            }
        }
        map[used] = -1;
        return false;
    }
}
