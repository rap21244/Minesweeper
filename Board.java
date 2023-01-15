class Board {
	private Square[][] board = new Square[16][16];

	Board() {
		int randomRow;
		int randomCol;
		// initialize all squares
		for (int row = 0; row < 16; row++) {
			for (int col = 0; col < 16; col++) {
				board[row][col] = new Square();
			}
		}
	
		// add random mines
		for (int i = 0; i < 40; i++) {
			Square square;

			randomRow = randInt(0, 15);
			randomCol = randInt(0, 15);
			
			do { 
				randomRow = randInt(0, 15);
				randomCol = randInt(0, 15);
				square = board[randomRow][randomCol]; 
			}
			while (square.isMine());
			square.setMine();
			
			incrementSurrounding(randomRow, randomCol);
		}
	}

	void incrementSurrounding(int row, int col){
		//THE LOCKS ARE COMING BACK BABY
		boolean openTop = (row > 0);
		boolean openBot = (row < 15);
		boolean openLeft = (col > 0);
		boolean openRight = (col < 15);

		if(openTop){board[row-1][col].incrementMine();}
		if(openBot){board[row+1][col].incrementMine();}
		if(openLeft){board[row][col-1].incrementMine();}
		if(openRight){board[row][col+1].incrementMine();}

		if(openTop && openLeft){board[row-1][col-1].incrementMine();}
		if(openTop && openRight){board[row-1][col+1].incrementMine();}
		if(openBot && openLeft){board[row+1][col-1].incrementMine();}
		if(openBot && openRight){board[row+1][col+1].incrementMine();}
	}

	// public Square[] getSorroundingSquares(int row, int col) {
	// 	return {};
	// }

	public String toString() {
		String formatted = "";
		
		for(int row = 0 ; row < 16 ; row++){
			//if(row + 1 < 10) formatted += " ";
			formatted += row + 1;
			formatted += "\t";
			for(int col = 0 ; col < 16 ; col++){
				formatted += board[row][col];
			}
			formatted += "\n";
		}

		formatted += "\n\tA  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P";
		return formatted;
	}

	private int randInt(int min, int max) {
		return min + (int)(Math.random() * ((max - min) + 1)); 
	}

	
}

