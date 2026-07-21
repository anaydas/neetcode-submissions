class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] result = new int[nums.length];
        Arrays.fill(result,1);
        
        int left = 0;
        int right = nums.length-1;

        int leftProd =1,rightProd =1;

        while(left<nums.length && right>-1){
            result[left] *= leftProd;
            result[right] *= rightProd;

            leftProd *= nums[left];
            rightProd *= nums[right];

            left++;
            right--;
        }
        return result;
    }
}  
