class Solution {
    public boolean canJump(int[] nums) {
        int maxR=0;
        for(int i=0;i<nums.length;i++){
            if(i>maxR)return false;
            maxR=Math.max(maxR,nums[i]+i);
        }
        return true;
    }
}
