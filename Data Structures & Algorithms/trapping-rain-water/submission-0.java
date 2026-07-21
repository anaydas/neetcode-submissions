class Solution {
    public int trap(int[] height) {

        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = 0;
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i-1]);
            System.out.println("Leftmax at index "+i+" is "+leftMax[i]);
        }

        rightMax[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i+1]);
            System.out.println("Rightmax at index "+i+" is "+rightMax[i]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if(Math.min(leftMax[i], rightMax[i]) - height[i] >= 0)    
                res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
        
    }
}
