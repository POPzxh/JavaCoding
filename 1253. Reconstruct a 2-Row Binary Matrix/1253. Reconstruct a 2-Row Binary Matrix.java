class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
       List<List<Integer>> ans = new ArrayList<>();
        int sum = 0;
        for(int col : colsum) sum+=col;
        if(sum != upper + lower) return ans;
        List<Integer> up = new ArrayList<>();
        List<Integer> low = new ArrayList<>();
        for(int i = 0 ;i<colsum.length;i++){
            int u = 0 , l = 0;
            if(colsum[i] == 2){
                u++;l++;
                upper--;lower--;
            }
            else if(colsum[i] == 1){
                if(upper>=lower){u++;upper--;}
                else {l++;lower--;}
            }
            if(upper<0||lower<0) return ans;
            up.add(u);low.add(l);
        }
        if(upper!=0||lower!=0) return ans;
        ans.add(up);
        ans.add(low);
        return ans; 
    }
}
