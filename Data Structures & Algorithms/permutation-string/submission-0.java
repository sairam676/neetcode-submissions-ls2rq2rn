class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length(),m=s2.length();
        if(n>m)return false;
        int[] freq=new int[26];
        for(char c:s1.toCharArray()){
            freq[c-'a']++;
        }
        int left=0,count=n;
        for(int right=0;right<m;right++){
            char r=s2.charAt(right);
            if(freq[r-'a']>0){
                count--;
            }
            freq[r-'a']--;
          if(right-left+1==n){
            if(count==0)return true;
            char l=s2.charAt(left);
            if(freq[l-'a']>=0){
                count++;
            }
            freq[l-'a']++;
            left++;
          }
        }
        return false;
    }
}
