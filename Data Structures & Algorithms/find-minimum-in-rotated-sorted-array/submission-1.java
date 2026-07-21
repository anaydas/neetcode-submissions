class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]>nums[right]){
                if(mid+1<=right && nums[mid]>nums[mid+1])
                    return nums[mid+1];
                else
                    left = mid+1;
            }else{
                if(mid-1>=left && nums[mid]<nums[mid-1])
                    return nums[mid];
                else 
                     right = mid-1;   
            }
        }
        return nums[left];
    }
}
