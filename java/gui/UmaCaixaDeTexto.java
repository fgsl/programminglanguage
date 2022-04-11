// JTextField e JPasswordField.
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
public class UmaCaixaDeTexto extends JFrame
{
    private final JTextField textField1; // campo de texto com tamanho configurado
    // construtor TextFieldFrame adiciona JTextFields a JFrame
    public UmaCaixaDeTexto()
    {
        super("Testando uma caixa de texto");
        setLayout(new FlowLayout());        
        textField1 = new JTextField("digite alguma coisa aqui");
        add(textField1); // adiciona textField1 ao JFrame
        // rotinas de tratamento de evento registradoras
        ControladorDaCaixaDeTexto controlador = new ControladorDaCaixaDeTexto();
        textField1.addActionListener(controlador);
    }
    // classe interna private para tratamento de evento
    private class ControladorDaCaixaDeTexto implements ActionListener
    {
        // processa eventos de campo de texto
        @Override
        public void actionPerformed(ActionEvent event)
        {
            String string = "Usuário pressionou enter";
            // usuário pressionou Enter no JTextField textField1
            JOptionPane.showMessageDialog(null,string);
        }
    } // fim da classe TextFieldHandler interna private
} // fim da classe TextFieldFrame
