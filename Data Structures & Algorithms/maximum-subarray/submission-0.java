class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE,curr=0;
        for(int x:nums){
            curr=Math.max(x,curr+x);
            max=Math.max(max,curr);
        }
        return max;
    }
}
