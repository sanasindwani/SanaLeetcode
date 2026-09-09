class Solution {
    public long minEnergy(int n, int brightness, int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
// at first we'll check for how long we want our light bulbs to stay on 
        // that is totalTime using startTime and endTime
        int startTime = intervals[0][0];
        int endTime = intervals[0][1];
        long totalTime = 0;
        // isko int lene se overflow ho raha tha and return statement mein bhi long type manga hai

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= endTime){
                endTime = Math.max(endTime, intervals[i][1]);
            } else {
                totalTime += (endTime - startTime + 1);
                startTime = intervals[i][0];
                endTime = intervals[i][1];
            }
        }

        totalTime += (endTime - startTime + 1);
// now we'll check how many bulbs we need to light up in total
        int count = (brightness + 2)/3;

        // dono ka multiplication is the total energy consumed
        return count*totalTime;
    }
}