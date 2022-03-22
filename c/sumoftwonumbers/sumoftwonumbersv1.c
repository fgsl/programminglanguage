#include <stdio.h>

void main(int argc, char *argv[])
{
        char number1 = *argv[1];
	char number2 = *argv[2];
	int sum = (number1 - '0')  + (number2 - '0');

	printf("Sum of %c and %c is %d \n",number1, number2, sum);
}
