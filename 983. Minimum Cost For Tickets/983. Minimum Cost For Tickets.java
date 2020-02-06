class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] costDays = new int[]{1,7,30};
        int dayPoint = 0;
        int[] dp = new int[lastDay + 1];
        for(int day = 1 ; day <= lastDay ; day++){
            int curDay = days[dayPoint];
            dp[day] = dp[day-1];
            if(curDay == day){
                int min = Integer.MAX_VALUE;
                for(int i = 0 ; i< 3; i++)
                    if(curDay-costDays[i]>=0)
                        min = Math.min(min , dp[curDay-costDays[i]]+costs[i]);
                    else
                       min = Math.min(min , dp[0]+costs[i]);
                dp[curDay] = min;
                dayPoint++;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[lastDay];
    }
}
