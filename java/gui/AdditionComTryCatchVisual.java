// Programa de adi��o que utiliza JOptionPane para entrada e sa�da.
import javax.swing.JOptionPane;
//import java.lang.NumberFormatException;

public class AdditionComTryCatchVisual
{
    public static void main(String[] args)
    {
        // obt�m a entrada de usu�rio a partir dos di�logos de entrada JOptionPane
        String firstNumber =
        JOptionPane.showInputDialog("Enter first integer");
        String secondNumber =
        JOptionPane.showInputDialog("Enter second integer");
        // converte String em valores int para utiliza��o em um c�lculo
	int number1 = 0, number2 = 0;
	try {
	        number1 = Integer.parseInt(firstNumber);
        	number2 = Integer.parseInt(secondNumber);
	} catch (NumberFormatException e){
		JOptionPane.showMessageDialog(null, "Voc� tem que digitar n�meros inteiros!", "Sum of Two Integers", JOptionPane.ERROR_MESSAGE);
		System.exit(0);
	}
        int sum = number1 + number2;
        // exibe o resultado em um di�logo de mensagem JOptionPane
        JOptionPane.showMessageDialog(null, "The sum is " + sum, "Sum of Two Integers", JOptionPane.PLAIN_MESSAGE);
    }
} // fim da classe Addition
