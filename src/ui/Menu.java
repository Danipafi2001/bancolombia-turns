package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.TurnList;

public class Menu {

	private TurnList list;

	public Menu() {
		list = new TurnList();
	}

	public void show() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean exit = true;
		do {
			System.out.println("Welcome!");
			System.out.println("Select an option");
			System.out.println("1. Add Turn");
			System.out.println("2. Show current Turn");
			System.out.println("3. Pass turn");
			System.out.println("4. Remove current turn");
			System.out.println("5. Exit");
			int option = 0;
			try {
				option = Integer.parseInt(br.readLine());
			} catch(NumberFormatException e) {
				option = 6;
			}
			String msg = "";
			switch(option) {
			case 1:
				msg = list.addTurn();
				System.out.println(msg);
				break;
			case 2:
				msg = list.showTurn();
				System.out.println(msg);
				break;
			case 3:
				msg = list.passTurn();
				System.out.println(msg);
				break;
			case 4:
				msg = list.removeTurn();
				System.out.println(msg);
				break;
			case 5:
				exit = false;
				break;
			default:
				System.out.println("Invalid option");
			}
		} while (exit);
	}
}
