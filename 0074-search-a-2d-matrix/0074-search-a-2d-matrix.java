class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // row-wise search
        int rowLow = 0;
        int rowHigh = matrix.length - 1;
        int rowMid;
        int lowest;
        int highest;
        while (rowLow < rowHigh) {
            rowMid = (rowLow + rowHigh) / 2;
            lowest = matrix[rowMid][0];
            highest = matrix[rowMid][matrix[0].length - 1];
            if (target >= lowest && target <= highest) {
                break;
            } 
            
            if (target < lowest) {
                rowHigh = rowMid;
            } else {
                rowLow = rowMid + 1;
            }
        }

        rowMid = (rowLow + rowHigh) / 2;
        lowest = matrix[rowMid][0];
        highest = matrix[rowMid][matrix[0].length - 1];
        if (target < lowest || target > highest) {
            return false;
        }

        int[] row = matrix[rowMid];
        int i = 0;
        int j = matrix[0].length - 1;
        int mid;
        while (i < j) {
            mid = (i + j)/2;
            if (row[mid] == target) {
                return true;
            }

            if (row[mid] > target) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }

        mid = (i + j)/2;
        if (row[mid] == target) {
            return true;
        }
        return false;
    }
}