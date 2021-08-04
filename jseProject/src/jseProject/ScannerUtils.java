package jseProject;

import java.util.Scanner;

public class ScannerUtils {

	private  Scanner sc = new Scanner(System.in);

	public int getInt() {
		do {
			if (this.sc.hasNextInt()) {
				return sc.nextInt();
			} else {
				sc.nextLine();
			}

		} while (true);

	}

	public String getText() {

		return (sc.nextLine());

	}
	public int numberRange(int min, int max) {
		int number;
		do {
			number = sc.nextInt();
			if (number >= 1 && number <= 40) {

				return number;
			} else {
				sc.nextLine();
			}

		} while(true);
	}
}
