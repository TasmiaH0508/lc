class Solution {
    public int countServers(int[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        int[] rowServers = new int[numRows];
        int[] colServers = new int[numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] == 1) {
                    rowServers[i]++;
                    colServers[j]++;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                boolean isConnect = (rowServers[i] > 1) || (colServers[j] > 1);
                if (grid[i][j] == 1 && isConnect) {
                    res++;
                }
            }
        }
        return res;
    }
}