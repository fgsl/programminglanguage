// Programa de adição que utiliza JOptionPane para entrada e saída.
import javax.swing.JOptionPane;
//import java.lang.NumberFormatException;

public class AdditionComTryCatch
{
    public static void main(String[] args)
    {
        // obtém a entrada de usuário a partir dos diálogos de entrada JOptionPane
        String firstNumber =
        JOptionPane.showInputDialog("Enter first integer");
        String secondNumber =
        JOptionPane.showInputDialog("Enter second integer");
        // converte String em valores int para utilização em um cálculo
	int number1 = 0, number2 = 0;
	try {
	        number1 = Integer.parseInt(firstNumber);
        	number2 = Integer.parseInt(secondNumber);
	} catch (NumberFormatException e){
		System.out.println("Você tem que digitar números inteiros!");
		System.exit(0);
	}
        int sum = number1 + number2;
        // exibe o resultado em um diálogo de mensagem JOptionPane
        JOptionPane.showMessageDialog(null, "The sum is " + sum, "Sum of Two Integers", JOptionPane.PLAIN_MESSAGE);
    }
} // fim da classe Addition
