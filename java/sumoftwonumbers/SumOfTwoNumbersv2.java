class SumOfTwoNumbersv2 {
	public static void main(String args[])
	{
		int number1;
		int number2;
		int number3;
		
		if (args.length < 3){
		    System.out.println("Você precisa digitar três números!");
		} else {
		    number1 = Integer.parseInt(args[0]);  
		    number2 = Integer.parseInt(args[1]);		
    		number3 = Integer.parseInt(args[2]);
    		System.out.println("Sum of " + number1 + " and " + number2 + "and " + number3 + " is " + (number1 + number2 + number3));
    	}
    }	
}
