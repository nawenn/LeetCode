public class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int index = 0;
        while(index< (row/2)){
            int[] temp = matrix[index];
            matrix[index] = matrix[row-index-1];
            matrix[row-index-1] = temp;
            index++;
        }
         for (int i = 0; i < matrix.length; ++i) {
            for (int j = i + 1; j < matrix[i].length; ++j){
                int s= matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = s;
            }
        }
    }
}