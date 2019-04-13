import java.util.Arrays;

public class CorrectPathDavid {

	public static void main(String[] args) {
		boolean[][] matrix = new boolean[5][5];
		
		String path = "RRRRDDDD";
				// "DDRRURDDLDD"; // out of bounds
				// "L"; // out of bounds
				// "RL"; // revisits node
				// "DRURDDLLDRDRURURDD"; // success
				//"RDDDRDRR"; // success
				// "RDLUDRRRRDD"; // revisits node
				//"DDDDRUUUURDDDDRUUUURDDDD"; // success
		
		matrix[0][0] = true;
		
	//	System.out.println(Arrays.deepToString(matrix).replace("],", "\n"));
		
		final int goalRow = 4, goalColumn = 4;
		
		int r = 0, c = 0;
		
		for(int i = 0; i < path.length(); i++)
		{
		//	System.out.println(i + " " + path.charAt(i));
			switch(path.charAt(i))
			{
				case 'R' : c++; break;
					
				case 'L' : c--; break;
				
				case 'D' : r++; break;
				
				case 'U' : r--; break;
				
				default: break;
			}
		//	System.out.println(r + " " + c);
			//System.out.println(Arrays.deepToString(matrix).replace("],", "\n"));
			
			// if it goes outside of bounds
			if(outOfBounds(matrix, r, c))
			{
				System.out.println("NOT VALID because it goes out of bounds");
				break;
			}
			else if(matrix[r][c] == true) // already visited
			{
				System.out.println("NOT VALID because it revisits a node");
				break;
			}
			
			else if(matrix[r][c] == false)
			{
				matrix[r][c] = true;
			}
			
		}
		
		// after all instructions iterated
		
		if(r == goalRow && c == goalColumn)
		{
			System.out.println("SUCCESSFUL STRING");
		}

	}
	
	public static boolean outOfBounds(boolean[][] matrix, int r, int c)
	{
		if(r < 0)
			return true;
		else if(r >= matrix.length)
			return true;
		else if(c < 0)
			return true;
		else if(c >= matrix[0].length)
			return true;
		else
			return false;
	}

}
