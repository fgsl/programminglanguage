import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class SumOfTwoNumbers2ComTratamentoDeExcecao {
	public static void main(String args[]) throws IOException 
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int number1 = 0;
		int number2 = 0;
		try {
			System.out.println("First number:");
			number1 = Integer.parseInt(reader.readLine());  
			System.out.println("Second number:");
			number2 = Integer.parseInt(reader.readLine());
		} catch(java.lang.NumberFormatException e) {
			System.out.println("Você tem que digitar números inteiros!");
			System.exit(0);	
		}
		System.out.println("Sum of " + number1 + " and " + number2 + " is " + (number1 + number2));
	}
}
