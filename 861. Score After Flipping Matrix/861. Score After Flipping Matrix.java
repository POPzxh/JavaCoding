class Solution {
    public int matrixScore(int[][] A) {
        for(int[] row : A){
            if(row[0] == 0){
                for(int i= 0 ;i<row.length ;i++){
                    if(row[i] == 1) row[i] = 0;
                    else row[i] = 1;
                }
            }
        }
        int sum = 0;
        int total = A.length;
        for(int i = 0 ;i<A[0].length ;i++){
            int oneSum = 0;
            for(int j = 0; j < A.length ;j++){
                oneSum += A[j][i];
            }
            if(oneSum <= total / 2) oneSum = total - oneSum;            
            sum += (1<<(A[0].length - i -1)) * oneSum;
        }
        return sum;
    }

