package c17;

public class TikTakToeGame {
	// First case: 
	// The function will be used for many times.
	// Implement converting 2-d char array to a number.
	
	public int charArrayToNum(char[][] board){
		int result = 0;
		int multiple = 1;
		for (int i = 0;i<board.length;i++){
			for (int j=0;j<board[0].length;j++){
				char curTile = board[i][j];
				int curDigit = 0;
				if (curTile=='o'){
					curDigit = 1;
				}
				if (curTile=='x'){
					curDigit = 2;
				}
				result += (curDigit*multiple);
				multiple*=3;
			}
		}
		return result;
	}
	public char checkWin(char[][] board){
		// Check rows.
		int i;
		int j;
		for (i=0;i<board.length;i++){
			char first = board[i][0];
			// not empty
			if (first!=' '){
				for (j=1;j<board[0].length;j++){
					if (board[i][j]!=first){
						break;
					}
				}
				if (j==board[0].length) return first;
			}
		}
		// Check cols
		for (i=0;i<board[0].length;i++){
			char first = board[0][i];
			if (first!=' '){
				for (j=1;j<board.length;j++){
					if (board[j][i]!=first){
						break;
					}
				}
				if (j==board.length) return first; 
			}
		}
		
		// Check left to right diagonal;
		if (board[0][0]!=' '){
			for (i=1;i<board.length;i++){
				if (board[i][i]!=board[0][0]){
					break;
				}
			}
			if (i==board.length) return board[0][0];
		}
		
		if (board[0][board[0].length]!=' '){
			for (i=1;i<board.length;i++){
				if (board[i][board[0].length-i]!=board[0][board[0].length]){
					break;
				}
			}
			if (i==board.length) return board[0][board[0].length];
			
		}
		return ' ';
	}
}
