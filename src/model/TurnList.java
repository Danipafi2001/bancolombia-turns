package model;

public class TurnList {
	
	public final static int MAX_SIZE = 50;
	
	private int size;
	
	private Turn current;
	private Turn head;

	public TurnList() {

	}

	public String addTurn() {
		if(size>=MAX_SIZE) {
			return "All turns were assigned";
		}
		if(head == null) {
			Turn newTurn = new Turn(1);
			head = newTurn;
			head.setNext(newTurn);
			head.setPrev(newTurn);
			current = head;
		} else {
			Turn newTurn = new Turn(head.getPrev().getNum()+1);
			newTurn.setPrev(head.getPrev());
			head.getPrev().setNext(newTurn);
			newTurn.setNext(head);
			head.setPrev(newTurn);
		}
		size++;
		return "New turn "+head.getPrev().getNum()+" added";
	}
	
	public String showTurn() {
		if(head == null)
			return "There are no turns";
		else
			return "Current turn is: "+current.getNum();
	}
	
	public String passTurn() {
		if(head == null)
			return "There are no turns";
		else {
			String msg = "";
			current.addPass();
			if(current.getPass()==3) {
				removeTurn();
				msg += "Current turn has been removed due to being called 3 times\n";
			} else {
				current = current.getNext();
			}
			if(size==0)
				msg += "There are no turns";
			else
				msg += "New current turn is: "+current.getNum();
			return msg;
		}
	}
	
	public String removeTurn() {
		if(head == null)
			return "There are no turns";
		else {
			if(size == 1) {
				head = null;
				current = null;
			} else {
				Turn p = current.getPrev();
				Turn n = current.getNext();
				if(current.equals(head)) {
					head = current.getNext();
				}
				current = current.getNext();
				p.setNext(n);
				n.setPrev(p);
			}
			size--;
			return "Current turn has been removed";
		}
	}
}