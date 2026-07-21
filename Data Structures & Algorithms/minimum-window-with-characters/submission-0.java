class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> mapT = new HashMap();
        Map<Character,Integer> mapS = new HashMap();

        for(char c: t.toCharArray()){
            mapT.put(c,mapT.getOrDefault(c,0)+1);
        }    

        int need = mapT.keySet().size();    

        int left = 0;
        int right = 0;

        int have = 0;
        int min_len = Integer.MAX_VALUE;
        int[] res = new int[2];
        res[0]=-1;
        res[1]=-1;

        while(right<s.length()){
            char c = s.charAt(right);
            mapS.put(c,mapS.getOrDefault(c,0)+1);
                
            if(mapT.containsKey(c) && mapS.get(c).equals(mapT.get(c))){
                have++;
            }    
                
                while(have==need){  
                    if(right-left+1 < min_len){
                        min_len = (right-left+1);
                        res[0] =left;
                        res[1] = right;
                    }
                    char leftChar = s.charAt(left);
                    mapS.put(leftChar,mapS.get(leftChar)-1);
                    
                    if(mapT.containsKey(leftChar) && mapS.get(leftChar)<mapT.get(leftChar))
                        have--;
                    
                    left++;
                }
            right++;
        }
        return res[0] == -1 ? "" : s.substring(res[0], res[1] + 1);
    }
}