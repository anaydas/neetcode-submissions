class Solution {
    public int trap(int[] height) {

        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int rightMax=0;
        int leftMax=0;

        int left=0;
        int right=height.length-1;

        int res = 0;

        while(left<right){

           leftMax = Math.max(leftMax, height[left]);
           rightMax = Math.max(rightMax, height[right]);

           if( leftMax < rightMax){

            res = res + (leftMax-height[left]);
            left++;

           }else{

            res = res + (rightMax-height[right]);
            right--;

           }     


        }
        return res;
    }
}
