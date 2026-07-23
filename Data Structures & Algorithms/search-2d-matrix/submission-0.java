class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        int lo = 0;
        int hi = (row*col)-1;

        while (lo<=hi){
            int mid = lo+(hi-lo)/2;
            int val = matrix[mid/row][mid%row];

            if(val==target)
                return true;
            else if (val<target)
                lo = mid+1;
            else 
                hi= mid-1;       
        }
        return false;    
    }
}
