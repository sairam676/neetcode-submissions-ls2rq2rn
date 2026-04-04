class Solution {
    public int jump(int[] nums) {
        int far=0,currE=0,jumps=0;
        for(int i=0;i<nums.length-1;i++){
            far=Math.max(far,nums[i]+i);
            if(currE==i){
jumps++;
currE=far;
            }
        }
        return jumps;
    }

}
