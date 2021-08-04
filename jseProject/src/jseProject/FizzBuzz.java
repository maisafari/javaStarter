package jseProject;

public class FizzBuzz {

	 

	public  void fizzBuzz(int num) {
		for (int i = 1; i <= num; i++) {
			if ((i % 5) == 0 && (i % 3) == 0) {
				System.out.println("FizzBuzz");
			} else if ((i % 3) == 0) {
				System.out.println("Fizz");
			} else if ((i % 5) == 0) {
				System.out.println("Buzz");
			} else
				System.out.println(i);
		}

	}

	public static void main(String[] args) {
		
		ScannerUtils su = new ScannerUtils(); 
		int inputNumber;
		System.out.println("Escreva um numero entre 1 e 40.");

		inputNumber = su.numberRange(1, 40);
		fizzBuzz(inputNumber);
	}
}
