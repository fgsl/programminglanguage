class SumOfTwoNumbers2SemElse {
	public static void main(String args[])
	{
		if (args.length < 2)
		{
			System.out.println("Você precisa digitar dois argumentos");
			System.exit(0);
		}
		int number1 = Integer.parseInt(args[0]);  
		int number2 = Integer.parseInt(args[1]);

		System.out.println("Sum of " + number1 + " and " + number2 + " is " + (number1 + number2));
	}
}
