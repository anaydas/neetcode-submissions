class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left =0;
        int right =0;
        int max_len = 0;
        Set<Character> set = new HashSet<>();

        while( right<s.length() ){


            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            
            set.add(s.charAt(right));
            max_len = Math.max(max_len, right-left+1 );
            right++;
        }
        return max_len;
    }
}
