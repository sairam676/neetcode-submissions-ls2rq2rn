class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> res=new ArrayList<>();
        int s=intervals[0][0];
        int e=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=e){
                e=Math.max(e,intervals[i][1]);
            }else{
                res.add(new int[]{s,e});
                s=intervals[i][0];
                e=intervals[i][1];
            }
        }
        res.add(new int[]{s,e});
        return res.toArray(new int[res.size()][]);
    }
}
