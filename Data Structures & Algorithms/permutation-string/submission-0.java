class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1count = new int[26];
        int[] s2count = new int[26];

        for(char c : s1.toCharArray()){
            s1count[c-'a']++;
        }

        int s1_length = s1.length();
        int left = 0;
        int right = s1_length-1;

        for(int i=left; i<=right; i++){
            s2count[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(s1count,s2count))
            return true;

        while(right < s2.length() - 1){
            

            s2count[s2.charAt(left)-'a']--;
            left++;
            right++;
            s2count[s2.charAt(right)-'a']++;

            if(Arrays.equals(s1count,s2count))
                return true;


        } 
        
        return false;
    }
}
