package model;

public class Turn {
	private int num;
	private int pass;
	
	private Turn prev;
	private Turn next;
	
	public Turn(int n) {
		num = n;
		pass = 0;
	}
	
	public int getNum() {
		return num;
	}
	
	public int getPass() {
		return pass;
	}
	
	public void addPass() {
		pass++;
	}

	public Turn getPrev() {
		return prev;
	}

	public void setPrev(Turn p) {
		prev = p;
	}

	public Turn getNext() {
		return next;
	}

	public void setNext(Turn n) {
		next = n;
	}
}