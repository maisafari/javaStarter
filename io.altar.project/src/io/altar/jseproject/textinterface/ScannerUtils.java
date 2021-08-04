package io.altar.jseproject.textinterface;

import java.util.Scanner;

public class ScannerUtils {

	private Scanner sc = new Scanner(System.in);

	public int getInt() {
		do {
			if (this.sc.hasNextInt()) {
				int result = sc.nextInt();
				sc.nextLine();
				return result;
			} else {
				sc.nextLine();
			}

		} while (true);

	}

	public float getFloat() {
		do {
			if (this.sc.hasNextFloat()) {
				float result = sc.nextFloat();
				sc.nextLine();
				return result;
			} else {
				sc.nextLine();
			}

		} while (true);

	}

	public long getLong() {
		do {
			if (this.sc.hasNextLong()) {
				long result = sc.nextLong();
				sc.nextLine();
				return result;
			} else {
				sc.nextLine();
			}

		} while (true);

	}

	public String getText() {

		return (sc.nextLine());

	}

	public void clearBuffer() {
		if (sc.hasNext()) {
			sc.nextLine();
		}
	}

	public int numberRange(int min, int max) {
		int number;
		do {
			number = sc.nextInt();
			if (number >= min && number <= max) {

				return number;
			} else {
				sc.nextLine();
			}

		} while (true);
	}

}