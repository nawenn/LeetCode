import java.util.HashSet;

public class Solution {
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
		//create 3 hashset to test wether each col, row, or square contains duplicate value
			HashSet<Integer> row = new HashSet<>();
			HashSet<Integer> col = new HashSet<>();
			HashSet<Integer> square = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				//if they do not equal to . then, get their numericavalue
				if (board[i][j] != '.') {
					int num = Character.getNumericValue(board[i][j]);
					//test to see if value already exist
					if (!(row.add(num))) {
						return false;
					}
				}
				if (board[j][i] != '.') {
					int num2 = Character.getNumericValue(board[j][i]);
					if (!(col.add(num2)))
						return false;
				}
				//i = 0 (0,0), i = 1 (0,1), i = 2 (0,2), i=3 (1,0)
				int RowIndex = 3 * (i / 3);
				int ColIndex = 3 * (i % 3);
				if (board[RowIndex+j/3][ColIndex+j%3] != '.') {
					int num3 = Character.getNumericValue(board[RowIndex+j/3][ColIndex+j%3]);
					if (!(square.add(num3))) {
						return false;
					}
				}
			}
		}
		return true;
	}