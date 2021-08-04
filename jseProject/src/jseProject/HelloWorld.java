package jseProject;

public class HelloWorld {

	public static void main(String[] args) {

		ScannerUtils scu = new ScannerUtils();

		System.out.println("Hello! What's your name?");
		String name = scu.getText();
		System.out.println("Name: " + name);

		System.out.println("Hello! What's your age?");
		int age = scu.getInt();
		System.out.print("Age : " + age);

	}
}
