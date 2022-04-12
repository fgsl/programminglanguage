// JLabels com texto e ícones.
import java.awt.FlowLayout; // especifica como os componentes são organizados
import javax.swing.JFrame; // fornece recursos básicos de janela
import javax.swing.JLabel; // exibe texto e imagens
import javax.swing.JOptionPane;
import javax.swing.SwingConstants; // constantes comuns utilizadas com Swing
import javax.swing.Icon; // interface utilizada para manipular imagens
import javax.swing.ImageIcon; // carrega imagens

public class MeuLabelFrame extends JFrame
{
    private final JLabel label1; // JLabel apenas com texto
    // construtor MeuLabelFrame adiciona JLabels a JFrame
    public MeuLabelFrame()
    {
        super("Flávio Gomes da Silva Lisboa");
        setLayout(new FlowLayout()); // configura o layout de frame
        // Construtor JLabel com um argumento de string
        // construtor JLabel com string, Icon e argumentos de alinhamento
        Icon bug = new ImageIcon(getClass().getResource( "lagobaikal.jpg"));
        label1 = new JLabel("Lago Baikal", bug, SwingConstants.CENTER);        
        label1.setHorizontalTextPosition(SwingConstants.CENTER);
        label1.setVerticalTextPosition(SwingConstants.CENTER);
        add(label1); // adiciona label3 ao JFrame        
        setVisible(true);
        setSize(600, 600); 
	String resposta = "";
	while (!resposta.toLowerCase().equals("sim") && !resposta.toLowerCase().equals("não")){
	        resposta = JOptionPane.showInputDialog(null,
	         "Você quer deixar a janela invisível");
	}
        if (resposta.toLowerCase().equals("sim")){
            setVisible(false);
            JOptionPane.showMessageDialog(this,
            "A janela está invisível agora",
            "Exercício de JOptionPane,Label e Frame",
            JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
} // fim da classe MeuLabelFrame
