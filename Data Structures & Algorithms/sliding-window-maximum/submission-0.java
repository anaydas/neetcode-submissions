class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int left = 0;
        int right = 0;

        int[] res = new int[nums.length - k +1];
        TreeMap<Integer,Integer> sortedMap = new TreeMap<>(Collections.reverseOrder());
        List<Integer> list = new ArrayList<>();
        
        while(right<nums.length){
            if(right < k){
                //add to map
                sortedMap.put(nums[right],sortedMap.getOrDefault(nums[right],0)+1);
                if(right==k-1)
                    list.add(sortedMap.firstKey());
            }else{
               // decrement and/or remove from map
               // add right to map
               // left++ right++;
               sortedMap.put(nums[left],sortedMap.get(nums[left])-1);
               if(sortedMap.get(nums[left])==0){
                    sortedMap.remove(nums[left]);
               }    
               sortedMap.put(nums[right],sortedMap.getOrDefault(nums[right],0)+1);
               list.add(sortedMap.firstKey());
               left++;
            }
            right++;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
