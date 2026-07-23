class Solution {

    public String encode(List<String> strs) {
        String encoded="";
        for(String str: strs)
            encoded = encoded+str.length()+"#"+str;   
        return encoded;    
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#')
                j=j+1;
            int length = Character.getNumericValue(str.charAt(j-1));
            decoded.add(str.substring(j+1,j+length+1));
            i = j+1+length;    
        }
        return decoded;
    }
}
