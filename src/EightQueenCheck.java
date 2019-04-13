import java.util.Scanner;

public class EightQueenCheck
{
	static boolean[][] board = new boolean[8][8];
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String places = input.nextLine();
		
	}
	
	public static boolean checkDiag(int row, int col)
	{
		
		for (int rowar = 0; rowar < row; rowar++)
		{
			for (int colar = 0; colar < col; colar++)
			{
				if (board[rowar][colar] == true)
				{
					
					// top right
					do
					{
						rowar--;
						colar++;
						if (board[rowar][colar] == true)
						{
							return false;
						}
						
						if (rowar == 0 || colar == 0)
						{
							return true;
						}
						
						// top left
						
						rowar--;
						colar--;
						if (board[rowar][colar] == true)
						{
							return false;
						}
						
						if (rowar == 0 || colar == 0)
						{
							return true;
						}
						
						// bottom right
						rowar++;
						colar++;
						if (board[rowar][colar] == true)
						{
							return false;
						}
						
						if (rowar == 0 || colar == 0)
						{
							return true;
						}
						
						// bottom left
						
						rowar++;
						colar--;
						if (board[rowar][colar] == true)
						{
							return false;
						}
						
						if (rowar == 0 || colar == 0)
						{
							return true;
						}
						
					} while (board[rowar][colar] == false);
					
				}
			}
		}
		return false;
	}
}
