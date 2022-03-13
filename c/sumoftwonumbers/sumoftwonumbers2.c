#include <stdio.h>

void main()
{
        int number1;
	int number2;

	printf("First number:");
	scanf("%d",&number1);

        printf("Second number");
        scanf("%d",&number2);

	int sum = number1 + number2;

	printf("Sum of %d and %d is %d \n",number1, number2, sum);
}
