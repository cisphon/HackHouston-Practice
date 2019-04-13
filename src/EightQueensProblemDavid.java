
public class EightQueensProblemDavid {
	
	static boolean[][] board;

	public static void main(String[] args) {
		
		boolean X = true, _  = false, master = true;
		
		// fill board with queens
		board = new boolean[][]{
			{_, _, _, _, _, X, _, _},
			{_, _, _, X, _, _, _, _},
			{_, _, _, _, _, _, X, _},
			{X, _, _, _, _, _, _, _},
			{_, _, _, _, _, _, _, X},
			{_, X, _, _, _, _, _, _},
			{_, _, _, _, X, _, _, _},
			{_, _, X, _, _, _, _, _}
		};
		
		board = new boolean[][]{
			{X, _, _, _, _, _, _, _},
			{_, _, _, _, _, _, X, _},
			{_, _, _, _, X, _, _, _},
			{_, _, _, _, _, _, _, X},
			{_, X, _, _, _, _, _, _},
			{_, _, _, X, _, _, _, _},
			{_, _, _, _, _, X, _, _},
			{_, _, X, _, _, _, _, _}
		};
		
		board = new boolean[][]{
			{X, _, _, _, _, _, _, _},
			{_, _, _, _, X, _, _, _},
			{_, _, _, _, _, _, _, X},
			{_, _, _, _, _, X, _, _},
			{_, _, X, _, _, _, _, _},
			{_, _, _, _, _, _, X, _},
			{_, X, _, _, _, _, _, _},
			{_, _, _, X, _, _, _, _}
		};
		
		
		
		
		lable:
		{
			for(int row = 0; row < board.length; row++) {
				for(int col = 0; col < board[0].length; col++) {
					// there is a queen here
					if(board[row][col]) {
						// if there isn't horizontal, vertical, or diagonals.
						if(!checkHorizontal(row) || !checkVertical(col) || !checkDiagonals(row, col)) {
							master = false;
							break lable;
						}
					}
				}
			}
		}
		System.out.println(master?"Is a solution!":"Not a solution!");
	}
	
	public static boolean checkHorizontal(int row)
	{
		byte queens = 0;
		
		for(int col = 0; col < 8; col++)
		{
			if(board[row][col] == true)
				queens++;
		}
		
		return queens == 1;
	}
	
	public static boolean checkVertical(int col)
	{
		byte queens = 0;
		
		for(int row = 0; row < 8; row++)
		{
			if(board[row][col] == true)
				queens++;
		}
		
		return queens == 1;
	}
	
	public static boolean checkDiagonals(int row, int col) 
	{
		int tempRow = row, tempCol = col;
		
		while(tempRow > 0 && tempCol > 0)
		{
			tempRow--;
			tempCol--;
		}
		
		int count = 0;
		
		while(tempRow < 8 && tempCol < 8)
		{
			if(board[tempRow][tempCol])
				count++;
			tempRow++;
			tempCol++;
		}
		
		if(count != 1)
			return false;
		
		tempCol = col + row;
		tempRow = 7;
		
		while(tempCol > 7)
		{
			tempCol--;
			tempRow--;
		}
		
		while(tempRow > -1 && tempCol > -1)
		{
			if(board[tempRow][tempCol])
				count++;
			tempRow--;
			tempCol--;
		}
		return true;
	}

}
