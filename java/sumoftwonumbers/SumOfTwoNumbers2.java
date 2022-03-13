import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class SumOfTwoNumbers2 {
	public static void main(String args[]) throws IOException 
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("First number:");
		int number1 = Integer.parseInt(reader.readLine());  
		System.out.println("Second number:");
		int number2 = Integer.parseInt(reader.readLine());

		System.out.println("Sum of " + number1 + " and " + number2 + " is " + (number1 + number2));
	}
}
