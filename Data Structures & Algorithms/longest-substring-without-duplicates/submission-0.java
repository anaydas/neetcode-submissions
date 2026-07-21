class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left =0;
        int right =0;
        int max_len = 0;
        Set<Character> set = new HashSet<>();

        while( right<s.length() ){
            
            if(set.contains(s.charAt(right))){
                while(s.charAt(left)!=s.charAt(right) && left<right){
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }else{
                set.add(s.charAt(right));
                max_len = Math.max(max_len, right-left+1 );
            }
            right++;
        }
        return max_len;
    }
}
