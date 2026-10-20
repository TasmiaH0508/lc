class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        int[][] newGrid = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                int newCol = (j + k) % numCols;

                // check the number of times first column is entered. 
                int numTimesFirstColEntered = (j + k) / numCols;
                int newRow = (i + numTimesFirstColEntered) % numRows;

                newGrid[newRow][newCol] = grid[i][j];
            }
        }

        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> ll = new LinkedList<>();
            for (int j = 0; j < numCols; j++) {
                ll.add(newGrid[i][j]);
            }
            res.add(ll);
        }
        return res;
    }
}