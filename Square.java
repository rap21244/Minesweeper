class Square{
	private int numberMines;//the amt of mines surrounding my boy
	private boolean flagged;
	private boolean covered;

	Square(){
		numberMines = 0;
		flagged = false;
		covered = true;
	}

	public void setMines(int numberOfSurroundingMines) {
		numberMines = numberOfSurroundingMines;
	}

	public int getMines(){
		return numberMines;
	}

	public boolean nearMines(){
		return(numberMines == 0);
	}

	public boolean isMine() {
		return (numberMines == 9);
	}

	public void setMine() {
		numberMines = 9;
	}

	public void flag(){
		flagged = true;
	}

	public void unflag(){
		flagged = false;
	}

	public void uncover(){
		covered = false;
	}

	public String toString() {
		if(!covered || !flagged){
			if(numberMines == 9)
				return "[X]";
			if(numberMines == 0)
				return "[O]";
			return "[" + numberMines + "]";
		}
		if(covered) return "[ ]";
		if(flagged) return "[F]";

		return "[0]";
	}

	public void incrementMine(){
		if(numberMines != 9) numberMines++;
	}
}