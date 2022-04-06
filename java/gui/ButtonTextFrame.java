
// Botões de comando, caixa de texto e eventos de ação.
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ButtonTextFrame extends JFrame {
    private final JLabel label;
    private final JTextField textField;
    private final JButton plainJButton; // botão apenas com texto

    public ButtonTextFrame() {
        super("Testing Textfield and Button");
        setLayout(new FlowLayout());
        label = new JLabel("Name:");
        add(label);
        textField = new JTextField("type your name");
        add(textField);
        plainJButton = new JButton("Plain Button"); // botão com texto
        add(plainJButton); // adiciona plainJButton ao JFrame
                // cria novo ButtonHandler de tratamento para tratamento de evento de botão
        ButtonHandler handler = new ButtonHandler();
        plainJButton.addActionListener(handler);
    }

    // classe interna para tratamento de evento de botão
    private class ButtonHandler implements ActionListener {
        // trata evento de botão
        @Override
        public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(ButtonTextFrame.this, String.format("You pressed: %s", event.getActionCommand()));
        }
    }
} // fim da classe ButtonFrame
