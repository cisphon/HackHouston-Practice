import java.util.ArrayList;

public class CorrectPath {
	
	static ArrayList<String> a = new ArrayList<>();
	
	public static void main(String[] args) {
		String input = "DDDDDRRRRU";
		System.out.println(startToEnd(input));
	}
	
	public static boolean startToEnd(String input) {
		int row = 0;
		int col = 0;
		

		// initialized start
		a.add("00");
		
		for(int i = 0; i < input.length(); i++) {
			String letter = "" + input.charAt(i);
			
			if(letter.equals("U") && row != 0 && notVisited(row - 1, col)) {
				--row;
			} else if (letter.equals("D") && row != 4 && notVisited(row + 1, col)) {
				++row;
			} else if (letter.equals("L") && col != 0 && notVisited(row, col - 1)) {
				--col;
			} else if (letter.equals("R") && col != 4 && notVisited(row, col + 1)) {
				++col;
			}
		}
		
		
		if(row == 4 && col == 4)
			return true;
		return false;
	}
	
	public static boolean notVisited(int r, int c) {
		if(a.contains("" + r + c))
			return false;
		return true;
	}
}